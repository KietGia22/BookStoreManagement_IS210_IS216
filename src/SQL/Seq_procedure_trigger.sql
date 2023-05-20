--SEQUENCE
CREATE SEQUENCE SQ_TK START WITH 1;
CREATE SEQUENCE SQ_S START WITH 1;
CREATE SEQUENCE SQ_HD START WITH 1;
CREATE SEQUENCE  SQ_TL START WITH 1;
CREATE SEQUENCE SQ_NCC START WITH 1;
CREATE SEQUENCE SQ_PN START WITH 1;
CREATE SEQUENCE SQ_KH START WITH 1;

----CONSTRAINT

ALTER TABLE KHACHHANG
ADD CONSTRAINT CHECKKH
CHECK(NGAYTAO > NGAYSINH);

ALTER TABLE TAIKHOAN
ADD CONSTRAINT CHECKTK
CHECK(NGAYTAOTAIKHOAN > NGAYSINH);

ALTER TABLE TAIKHOAN
ADD CONSTRAINT CHECKTUOI
CHECK ((EXTRACT(YEAR FROM NGAYTAOTAIKHOAN) - EXTRACT(YEAR FROM NGAYSINH)) > 17);

ALTER TABLE SACH
ADD CONSTRAINT CHECKSLTON
CHECK (SLTON >= 0);

ALTER TABLE LUONG 
ADD CONSTRAINT CHECK_THANG
CHECK (THANG IN (1, 12));

ALTER TABLE KHACHHANG
ADD CONSTRAINT CHECK_SDTKH
CHECK ((LENGTH(SDT)) = 10 AND (SDT LIKE '0%'));

ALTER TABLE TAIKHOAN
ADD CONSTRAINT CHECK_SDTTK
CHECK ((LENGTH(SDT)) = 10 AND (SDT LIKE '0%'));

ALTER TABLE NHACUNGCAP
ADD CONSTRAINT CHECK_SDTNCC
CHECK ((LENGTH(SDT)) = 10 AND (SDT LIKE '0%'));


-----SESSION
ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YYYY HH24:MI:SS';

----PROCEDURE

----FUNCTION

---TRIGGER
/*Khi insert, update mot CTPN thi Tong tien nhap cung thay doi*/
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_TIENNHAP_INSERT_UPDATE_CTPN
BEFORE INSERT OR UPDATE ON CTPN 
FOR EACH ROW
DECLARE
BEGIN
    UPDATE PHIEUNHAP
    SET TONGTIENNHAP = TONGTIENNHAP + (:NEW.SLNHAP * :NEW.GIANHAP)
    WHERE MAPHIEUNHAP = :NEW.MAPHIEUNHAP;
    
    UPDATE SANPHAM
    SET SLSAN = SLSAN + :NEW.SLNHAP
    WHERE MASP = :NEW.MASP;
END;
/
/*Khi delete, update mot CTPN thi Tong tien nhap cung thay doi*/
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_TIENNHAP_DELETE_UPDATE_CTPN
BEFORE DELETE OR UPDATE ON CTPN 
FOR EACH ROW
DECLARE
BEGIN
    UPDATE PHIEUNHAP
    SET TONGTIENNHAP = TONGTIENNHAP - (:OLD.SLNHAP * :OLD.GIANHAP)
    WHERE MAPHIEUNHAP = :OLD.MAPHIEUNHAP;
    
    UPDATE SANPHAM
    SET SLSAN = SLSAN - :OLD.SLNHAP
    WHERE MASP = :OLD.MASP;
END;
/

--Tong tien cua mot hoa don l� tong thanh tien (soluong*gia) cua cac chi tiet thuoc hoa don do.
/*Khi insert, update mot CTHD thi Tong tien cua hoa don cung thay doi*/
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_TONGTIEN_INSERT_UPDATE_CTHD
AFTER INSERT OR UPDATE ON CTHD 
FOR EACH ROW
DECLARE
    var_giaban SANPHAM.GIA%TYPE;
BEGIN
    SELECT GIA INTO var_giaban
    FROM SANPHAM
    WHERE MASP = :NEW.MASP;

    UPDATE HOADON
    SET TONGTIEN = TONGTIEN + (:NEW.SOLUONG * var_giaban)
    WHERE SOHD = :NEW.SOHD;
    
    UPDATE SANPHAM
    SET SLSAN = SLSAN - :NEW.SOLUONG
    WHERE MASP = :NEW.MASP;
END;
/

/*Khi delete, update mot CTHD thi Tong tien cua hoa don cung thay doi*/
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_TONGTIEN_DELETE_UPDATE_CTHD
AFTER DELETE OR UPDATE ON CTHD 
FOR EACH ROW
DECLARE
    var_giaban SANPHAM.GIA%TYPE;
BEGIN
    SELECT GIA INTO var_giaban
    FROM SANPHAM
    WHERE MASP = :OLD.MASP;

    UPDATE HOADON
    SET TONGTIEN = TONGTIEN - (:OLD.SOLUONG * var_giaban)
    WHERE SOHD = :OLD.SOHD;
    
    UPDATE SANPHAM
    SET SLSAN = SLSAN + :OLD.SOLUONG
    WHERE MASP = :OLD.MASP;
END;
/

--Ph?n tr?m c�c khuy?n m�i cho m?t h�a ??n ???c c?ng v�o chi?t kh?u c?a h�a ??n ?�.
/*Khi insert, update mot CTKM thi chiet khau cua hoa don cung thay doi*/
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_CHIETKHAU_INSERT_UPDATE_CTKM
AFTER INSERT OR UPDATE ON CTKM
FOR EACH ROW
DECLARE
    var_phantram KHUYENMAI.PHANTRAM%TYPE;
BEGIN
    SELECT PHANTRAM INTO var_phantram
    FROM KHUYENMAI
    WHERE MAKM = :NEW.MAKM;
    
    UPDATE HOADON
    SET CHIETKHAU = CHIETKHAU + var_phantram
    WHERE SOHD = :NEW.SOHD;
END;
/

/*Khi delete, update mot CTKM thi chiet khau cua hoa don cung thay doi*/
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_CHIETKHAU_DELETE_UPDATE_CTKM
AFTER DELETE OR UPDATE ON CTKM
FOR EACH ROW
DECLARE
    var_phantram KHUYENMAI.PHANTRAM%TYPE;
BEGIN
    SELECT PHANTRAM INTO var_phantram
    FROM KHUYENMAI
    WHERE MAKM = :OLD.MAKM;
    
    UPDATE HOADON
    SET CHIETKHAU = CHIETKHAU - var_phantram
    WHERE SOHD = :OLD.SOHD;
END;
/

--Ngay ban hang (NGHD) cua mot nhan vien phai lon hon hoac bang ngay nhan vien do vao lam.
/*Bang HOADON*/
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_NGAYHD_NGAYVL_HOADON
AFTER INSERT OR UPDATE 
ON HOADON FOR EACH ROW
DECLARE
    var_ngayvl NHANVIEN.NGAYVL%TYPE;
BEGIN
    SELECT NGAYVL INTO var_ngayvl
    FROM NHANVIEN
    WHERE MANV = :NEW.MANV;
    
    IF(:NEW.NGAYHD < var_ngayvl) THEN
        RAISE_APPLICATION_ERROR(-20000,'Ngay ban hang truoc ngay vao lam cua nhan vien.');
    END IF;
END;
/

/*Bang NHANVIEN*/
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_NGAYHD_NGAYVL_NHANVIEN
AFTER UPDATE OF NGAYVL ON NHANVIEN 
FOR EACH ROW
DECLARE
    var_ngayhd HOADON.NGAYHD%TYPE;
    cur_hd HOADON.SOHD%TYPE;
    CURSOR cur IS SELECT SOHD
                FROM HOADON 
                WHERE MANV = :NEW.MANV;
BEGIN
    OPEN cur;
    LOOP
        FETCH cur INTO cur_hd;
        EXIT WHEN cur%NOTFOUND;
        
        SELECT NGAYHD INTO var_ngayhd
        FROM HOADON
        WHERE SOHD = cur_hd;
        
        IF(:NEW.NGAYVL > var_ngayhd) THEN
            RAISE_APPLICATION_ERROR(-20000,'Ngay ban hang truoc ngay vao lam cua nhan vien.');
        END IF;
    END LOOP;
END;
/

--Ngay mua hang (NGHD) cua mot khach hang thanh vien se lon hon hoac bang ngay khach hang do dang ky thanh vien (NGDK). 
/*Bang HOADON*/
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_NGAYHD_NGAYDK_HOADON
AFTER INSERT OR UPDATE 
ON HOADON FOR EACH ROW
DECLARE
    var_ngaydk KHACHHANG.NGAYDK%TYPE;
BEGIN
    SELECT NGAYDK INTO var_ngaydk
    FROM KHACHHANG
    WHERE MAKH = :NEW.MAKH;
    
    IF(:NEW.NGAYHD < var_ngaydk) THEN
        RAISE_APPLICATION_ERROR(-20000,'Ngay mua hang truoc ngay dang ky thanh vien cua khach hang.');
    END IF;

EXCEPTION 
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Khach hang nay chua dang ky lam khach hang thanh vien!');
END;
/

/*Bang KHACHHANG*/
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_NGAYHD_NGAYDK_KHACHHANG
AFTER UPDATE OF NGAYDK ON KHACHHANG 
FOR EACH ROW
DECLARE
    var_ngayhd HOADON.NGAYHD%TYPE;
    cur_hd HOADON.SOHD%TYPE;
    CURSOR cur IS SELECT SOHD
                FROM HOADON 
                WHERE MAKH = :NEW.MAKH;
BEGIN
    OPEN cur;
    LOOP
        FETCH cur INTO cur_hd;
        EXIT WHEN cur%NOTFOUND;
        
        SELECT NGAYHD INTO var_ngayhd
        FROM HOADON
        WHERE SOHD = cur_hd;
        
        IF(:NEW.NGAYDK > var_ngayhd) THEN
            RAISE_APPLICATION_ERROR(-20000,'Ngay mua hang truoc ngay dang ky thanh vien cua khach hang.');
        END IF;
    END LOOP;
END;
/
--Tich luy cua mot khach hang la tong tri gia cac hoa don ma khach hang thanh vien do da mua. Dong thoi cap nhat loai khach hang
--Cap nhat loai KH:
--	+ Tich luy tu <10000000 la khach hang m?i
--	+ Tich luy tu >10000000 - 30000000 la khach hang th�n thi?t.
--	+ Tich luy >30000000 la khach hang VIP.
/*Khi insert, update mot hoa don thi tich luy cua khach hang so huu hoa don do cung thay doi*/
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_TICHLUY_INSERT_UPDATE_HOADON
AFTER INSERT OR UPDATE ON HOADON 
FOR EACH ROW
DECLARE
    var_tichluy KHACHHANG.TICHLUY%TYPE;
BEGIN
    IF :NEW.MAKH IS NOT NULL
    THEN
        UPDATE KHACHHANG
        SET TICHLUY = TICHLUY + :NEW.TRIGIAHD
        WHERE MAKH = :NEW.MAKH;
        
        SELECT TICHLUY INTO var_tichluy
        FROM KHACHHANG
        WHERE MAKH = :NEW.MAKH;
        
        IF(var_tichluy > 10000000 AND var_tichluy <= 30000000)
        THEN
            UPDATE KHACHHANG
            SET LOAIKH = 'Than thiet'
            WHERE MAKH = :NEW.MAKH;
        END IF;
        IF(var_tichluy > 30000000) THEN
            UPDATE KHACHHANG
            SET LOAIKH = N'VIP'
            WHERE MAKH = :NEW.MAKH;
        END IF;
    END IF;
END;
/

/*Khi delete, update mot hoa don thi tich luy cua khach hang so huu hoa don do cung thay doi*/
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_TICHLUY_DELETE_UPDATE_HOADON
AFTER DELETE OR UPDATE ON HOADON
FOR EACH ROW
DECLARE
    var_tichluy KHACHHANG.TICHLUY%TYPE;
BEGIN
    IF :OLD.MAKH IS NOT NULL
    THEN
        UPDATE KHACHHANG
        SET TICHLUY = TICHLUY - :OLD.TRIGIAHD
        WHERE MAKH = :OLD.MAKH;
        
        SELECT TICHLUY INTO var_tichluy
        FROM KHACHHANG
        WHERE MAKH = :NEW.MAKH;
        
        IF(var_tichluy > 10000000 AND var_tichluy <= 30000000)
        THEN
            UPDATE KHACHHANG
            SET LOAIKH = N'Than thiet'
            WHERE MAKH = :NEW.MAKH;
        END IF;
        IF(var_tichluy < 10000000) THEN
            UPDATE KHACHHANG
            SET LOAIKH = N'Moi'
            WHERE MAKH = :NEW.MAKH;
        END IF;
    END IF;
END;
/

--tri gia cua mot hoa don thay doi khi tong tien hoac chiet khau cua hoa don do thay doi.
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_THAYDOITIEN_HOADON
BEFORE UPDATE
ON HOADON FOR EACH ROW
DECLARE
BEGIN
    :NEW.TRIGIAHD := :NEW.TONGTIEN - :NEW.TONGTIEN * :NEW.CHIETKHAU;
END;
/

--Khi them mot hoa don thi ngay hoa don la ngay hien tai
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_INSERT_NGAYHD_HOADON
BEFORE INSERT
ON HOADON FOR EACH ROW
DECLARE
BEGIN
    :NEW.NGAYHD := SYSDATE;
END;
/
--Khi insert 1 khach hang thi ngay dang ky bang ngay hien tai.
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_INSERT_NGAYDK_KHACHHANG
BEFORE INSERT
ON KHACHHANG FOR EACH ROW
DECLARE
BEGIN
    :NEW.NGAYDK := SYSDATE;
END;
/

--Kh�ng th? update th?i ?i?m checkin c?a m?t ch?m c�ng
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_UPDATE_CHECKIN
BEFORE UPDATE OF CHECKIN ON CHAMCONG
FOR EACH ROW
DECLARE
BEGIN
    RAISE_APPLICATION_ERROR(-20000, 'Kh�ng ???c s?a checkin!');
END;
/

--Trong mot cham cong, khi update thoi diem checkout th� so gio lam cung thay doi.
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_UPDATE_CHECKOUT 
BEFORE UPDATE OF CHECKOUT ON CHAMCONG
FOR EACH ROW
DECLARE
    var_sogiolam NUMBER;
    var_ngaycuoituan DATE;
BEGIN   
    var_sogiolam := (TO_DATE(to_char(:NEW.CHECKOUT, 'DD/MM/YYYY HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS') - TO_DATE(to_char(:NEW.CHECKIN, 'DD/MM/YYYY HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS')) * 24;
        
    var_ngaycuoituan := NEXT_DAY(:NEW.CHECKOUT,'SATURDAY');
    IF(TO_DATE(var_ngaycuoituan,'DD/MM/YYYY HH24:MI:SS') - TO_DATE(:NEW.CHECKOUT,'DD/MM/YYYY HH24:MI:SS') = 7 
       OR TO_DATE(var_ngaycuoituan,'DD/MM/YYYY HH24:MI:SS') - TO_DATE(:NEW.CHECKOUT,'DD/MM/YYYY HH24:MI:SS') = 6) 
    THEN
        :NEW.SOGIOLAM := var_sogiolam * 2;
    ELSE
        :NEW.SOGIOLAM := var_sogiolam;
    END IF;
END;
/

--Khi th�m m?t th�ng l??ng cho nh�n vi�n th� l??ng c?a nh�n vi�n ?� v�o th�ng ?� t? c?p nh?t.
SET DEFINE OFF;
CREATE OR REPLACE TRIGGER TRIGGER_INSERT_LUONG
BEFORE INSERT ON LUONG
FOR EACH ROW
DECLARE 
    var_luongcoban NHANVIEN.LUONGCOBAN%TYPE;
BEGIN
    SELECT LUONGCOBAN INTO var_luongcoban
    FROM NHANVIEN
    WHERE MANV = :NEW.MANV; 

    :NEW.SOGIOLAMTC := TinhSoGioLamTieuChuan(:NEW.THANG, :NEW.NAM);
    :NEW.SOGIOLAMTT := TinhSoGioLamThucTe(:NEW.THANG, :NEW.NAM, :NEW.MANV);
    :NEW.LUONG := (var_luongcoban/:NEW.SOGIOLAMTC)*:NEW.SOGIOLAMTT;
END;
