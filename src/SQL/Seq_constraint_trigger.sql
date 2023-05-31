--SEQUENCE
CREATE SEQUENCE SQ_TK INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SQ_S INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SQ_HD INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE  SQ_TL INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SQ_NCC INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SQ_PN INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SQ_KH INCREMENT BY 1 START WITH 1;

----CONSTRAINT

ALTER TABLE KHACHHANG
ADD CONSTRAINT CHECKKH
CHECK(NGAYTAO > NGAYSINH);
/
ALTER TABLE TAIKHOAN
ADD CONSTRAINT CHECKTK
CHECK(NGAYTAOTAIKHOAN > NGAYSINH);
/
ALTER TABLE KHACHHANG
ADD CONSTRAINT CHECK_CCCD
CHECK(LENGTH(CCCD)=12);
/
ALTER TABLE TAIKHOAN
ADD CONSTRAINT CHECKTUOI
CHECK ((EXTRACT(YEAR FROM NGAYTAOTAIKHOAN) - EXTRACT(YEAR FROM NGAYSINH)) > 17);
/
ALTER TABLE SACH
ADD CONSTRAINT CHECKSLTON
CHECK (SLTON >= 0);
/
ALTER TABLE LUONG 
ADD CONSTRAINT CHECK_THANG
CHECK (THANG BETWEEN 1 AND 12);
/
ALTER TABLE KHACHHANG
ADD CONSTRAINT CHECK_SDTKH
CHECK ((LENGTH(SDT)) = 10 AND (SDT LIKE '0%'));

ALTER TABLE TAIKHOAN
ADD CONSTRAINT CHECK_SDTTK
CHECK ((LENGTH(SDT)) = 10 AND (SDT LIKE '0%'));
/
ALTER TABLE NHACUNGCAP
ADD CONSTRAINT CHECK_SDTNCC
CHECK ((LENGTH(SDT)) = 10 AND (SDT LIKE '0%'));
/
ALTER TABLE TAIKHOAN 
ADD CONSTRAINT CHECK_CV
CHECK (CHUCVU IN ('Qu?n l�', 'Nh�n vi�n', 'Nh�n vi�n kho', 'K? to�n'));
/
----PROCEDURE

----FUNCTION

---TRIGGER;
--NGAY TAO HOA DON PHAI LON HON NGAY VAO LAM CUA NHAN VIEN DO
CREATE OR REPLACE TRIGGER HOADON_CHECKNGAY
AFTER INSERT OR UPDATE ON HOADON 
FOR EACH ROW
DECLARE
    NGAY  TAIKHOAN.NGAYTAOTAIKHOAN%TYPE;
BEGIN
    SELECT NGAYTAOTAIKHOAN INTO NGAY
    FROM TAIKHOAN
    WHERE MATK = :NEW.MATK;

    IF(:NEW.NGAYTAOHD < NGAY) THEN
        RAISE_APPLICATION_ERROR(-20900,'NGAY TAO HOA DON PHAI LON HON NGAY VAO LAM CUA NHAN VIEN.');
    END IF;
    
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('KHONG TIM THAY DU LIEU');
END;
/
CREATE OR REPLACE TRIGGER TAIKHOAN_CHECKNGAY
AFTER UPDATE OF NGAYTAOTAIKHOAN ON TAIKHOAN 
FOR EACH ROW
DECLARE
    NGAY HOADON.NGAYTAOHD%TYPE;
    MHD HOADON.MAHD%TYPE;
    CURSOR c_hd IS SELECT MAHD FROM HOADON 
                  WHERE MATK = :NEW.MATK;
BEGIN
    OPEN c_hd;
    LOOP
        FETCH c_hd INTO MHD;
        EXIT WHEN c_hd%NOTFOUND;
        
        SELECT NGAYTAOHD INTO NGAY
        FROM HOADON
        WHERE MAHD = MHD;
        
        IF(NGAY < :NEW.NGAYTAOTAIKHOAN) THEN
             RAISE_APPLICATION_ERROR(-20900,'NGAY TAO HOA DON PHAI LON HON NGAY VAO LAM CUA NHAN VIEN.');
    END IF;
    END LOOP;
END;
/
--NGAY TAO HOA DON PHAI LON HON NGAY TAO TAI KHOAN CUA KHACHHANG DO
CREATE OR REPLACE TRIGGER HOADON_CHECKNGAY_KH
AFTER INSERT OR UPDATE ON HOADON 
FOR EACH ROW
DECLARE
    NGAY KHACHHANG.NGAYTAO%TYPE;
BEGIN
    SELECT NGAYTAO INTO NGAY
    FROM KHACHHANG
    WHERE MAKH = :NEW.MAKH;

    IF(:NEW.NGAYTAOHD < NGAY) THEN
        RAISE_APPLICATION_ERROR(-20901,'NGAY TAO HOA DON PHAI LON HON NGAY TAO TAI KHOAN CUA KHACHHANG');
    END IF;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('KHONG TIM THAY DU LIEU');
END;
/
CREATE OR REPLACE TRIGGER KHACHHANG_CHECKNGAY
AFTER UPDATE OF NGAYTAO ON KHACHHANG
FOR EACH ROW
DECLARE
    NGAY HOADON.NGAYTAOHD%TYPE;
    MHD HOADON.MAHD%TYPE;
    CURSOR c_hd IS SELECT MAHD FROM HOADON 
                  WHERE MAKH = :NEW.MAKH;
BEGIN
    OPEN c_hd;
    LOOP
        FETCH c_hd INTO MHD;
        EXIT WHEN c_hd%NOTFOUND;
        
        SELECT NGAYTAOHD INTO NGAY
        FROM HOADON
        WHERE MAHD = MHD;
        
        IF(NGAY < :NEW.NGAYTAO) THEN
             RAISE_APPLICATION_ERROR(-20901,'NGAY TAO HOA DON PHAI LON HON NGAY TAO TAI KHOAN CUA KHACHHANG');
    END IF;
    END LOOP;
END;
/
--KHI INSERT, UPDATE CTHD THI SACH, HOA DON CUNG THAY DOI
CREATE OR REPLACE TRIGGER CTHD_INSERT_UPDATE
BEFORE INSERT OR UPDATE ON CTHD 
FOR EACH ROW
DECLARE
    GIABAN SACH.GIA%TYPE;
BEGIN
    SELECT GIA INTO GIABAN
    FROM SACH
    WHERE MASACH = :NEW.MASACH;

    UPDATE HOADON
    SET TONGTIEN = TONGTIEN + (:NEW.SOLUONG * GIABAN)
    WHERE MAHD = :NEW.MAHD;
    
    UPDATE SACH
    SET SLTON = SLTON - :NEW.SOLUONG
    WHERE  MASACH = :NEW.MASACH;
END;
/
--KHI DELETE CTHD THI SACH, HOA DON CUNG THAY DOI
CREATE OR REPLACE TRIGGER CTHD_DELETE
BEFORE DELETE ON CTHD 
FOR EACH ROW
DECLARE
     GIABAN SACH.GIA%TYPE;
BEGIN
    SELECT GIA INTO GIABAN
    FROM SACH
    WHERE MASACH = :OLD.MASACH;

    UPDATE HOADON
    SET TONGTIEN = TONGTIEN - (:OLD.SOLUONG * GIABAN)
    WHERE MAHD = :OLD.MAHD;
    
    UPDATE SACH
    SET SLTON = SLTON +  :OLD.SOLUONG
    WHERE  MASACH =  :OLD.MASACH;
END;
/
--KHI INSERT HOAC UPATE O CTPN THI PHIEUNHAP VA SACH CUNG THAY DOI
CREATE OR REPLACE TRIGGER CTPN_INSERT_UPDATE
BEFORE INSERT OR UPDATE ON CTPN 
FOR EACH ROW
BEGIN
    UPDATE PHIEUNHAP
    SET TONGTIENNHAP = TONGTIENNHAP + (:NEW.SOLUONGNHAP  * :NEW.GIANHAP)
    WHERE MAPN = :NEW.MAPN;
    
    UPDATE SACH
    SET SLTON = SLTON + :NEW.SOLUONGNHAP
    WHERE MASACH = :NEW.MASACH;
END;
/
--DELETE O CTPN THI PHIEU NHAP VA SACH CUNG THAY DOI
CREATE OR REPLACE TRIGGER CTPN_DELETE
BEFORE DELETE ON CTPN 
FOR EACH ROW
BEGIN
    UPDATE PHIEUNHAP
   SET TONGTIENNHAP = TONGTIENNHAP - (:OLD.SOLUONGNHAP  * :OLD.GIANHAP)
    WHERE MAPN = :OLD.MAPN;
    
    UPDATE SACH
    SET SLTON = SLTON - :OLD.SOLUONGNHAP
    WHERE MASACH = :OLD.MASACH;
END;
/
--GAN NGAY CHO HOA DON LA NGAY HIEN TAI
CREATE OR REPLACE TRIGGER TAONGAY_HD
BEFORE INSERT ON HOADON 
FOR EACH ROW
BEGIN
    :NEW.NGAYTAOHD := SYSDATE;
END;
/
--GAN NGAY THEM KHACH HANG LA NGAY HIEN TAI
CREATE OR REPLACE TRIGGER TAONGAY_KH
BEFORE INSERT ON KHACHHANG
FOR EACH ROW
BEGIN
    :NEW.NGAYTAO := SYSDATE;
END;
/
--GAN BATDAULAM LA NGAY HIEN TAI
CREATE OR REPLACE TRIGGER TAONGAY_BD
BEFORE INSERT ON CHAMCONG
FOR EACH ROW
BEGIN
    :NEW.BATDAULAM := SYSDATE;
END;
/
--GAN NGAY CHO PHIEU NHAP LA NGAY HIEN TAI
CREATE OR REPLACE TRIGGER TAONGAY_PN
BEFORE INSERT ON PHIEUNHAP 
FOR EACH ROW
BEGIN
    :NEW.NGAYNHAP := SYSDATE;
END;
/
--KHONG UPDATE KHI DA BAT DAU CHAM CONG
CREATE OR REPLACE TRIGGER NO_UPDATE_CC
BEFORE UPDATE OF BATDAULAM ON CHAMCONG
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20899, 'KHONG SUA THOI GIAN BAT DAU');
END;
/
--THAY DOI SU KETTHUC TREN BANG CHAMCONG
CREATE OR REPLACE TRIGGER UPDATE_KETTHUC
BEFORE UPDATE OF KETTHUC ON CHAMCONG
FOR EACH ROW
DECLARE
    SOGIO NUMBER;
BEGIN   
    SOGIO := (:NEW.KETTHUC - :NEW.BATDAULAM) * 24;
    :NEW.SOGIOLAM := SOGIO;
END;
/
--THEM THONG TIN LUONG VAO BANG LUONG
CREATE OR REPLACE TRIGGER LUONG_INSERT
BEFORE INSERT ON LUONG
FOR EACH ROW
DECLARE 
    SALARY TAIKHOAN.LUONG%TYPE;
BEGIN
    SELECT LUONG INTO SALARY
    FROM TAIKHOAN
    WHERE MATK = :NEW.MATK; 
    :NEW.SOGIOLAM := GIOLAMVIEC(:NEW.THANG, :NEW.NAM, :NEW.MATK);
    :NEW.LUONG := SALARY * :NEW.SOGIOLAM;
END;
