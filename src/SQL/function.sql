set serveroutput on;
--DOANH THU THEO THANG
CREATE OR REPLACE FUNCTION GET_DT_THANG (month_out NUMBER, year_out NUMBER) RETURN NUMBER
AS 
     dt NUMBER;
BEGIN
    SELECT SUM(TONGTIENHD) INTO dt
    FROM HOADON
    WHERE EXTRACT(MONTH FROM NGAYTAOHD) = month_out
    AND EXTRACT(YEAR FROM NGAYTAOHD) = year_out;
    RETURN dt;
END;
/
--DOANH THU THEO NAM
CREATE OR REPLACE FUNCTION GET_DT_NAM (year_out NUMBER) RETURN NUMBER
AS 
     dt NUMBER;
BEGIN
    SELECT SUM(TONGTIENHD) INTO dt
    FROM HOADON
    WHERE EXTRACT(YEAR FROM NGAYTAOHD) = year_out;
    RETURN dt;
END;
/
--TIEN NHAP THEO THANG
CREATE OR REPLACE FUNCTION GET_NHAP_THANG (month_out NUMBER, year_out NUMBER) RETURN NUMBER
AS 
     dt NUMBER;
BEGIN
    SELECT SUM(TONGTIENNHAPSACH) INTO dt
    FROM PHIEUNHAPSACH
    WHERE EXTRACT(MONTH FROM NGAYNHAPSACH) = month_out
    AND EXTRACT(YEAR FROM NGAYNHAPSACH) = year_out;
    RETURN dt;
END;
/
--TIEN NHAP THEO NAM
CREATE OR REPLACE FUNCTION GET_NHAP_NAM (year_out NUMBER) RETURN NUMBER
AS 
     dt NUMBER;
BEGIN
    SELECT SUM(TONGTIENNHAPSACH) INTO dt
    FROM PHIEUNHAPSACH
    WHERE EXTRACT(YEAR FROM NGAYNHAPSACH) = year_out;
    RETURN dt;
END;
/
--TINH SO GIO LAM CUA NHAN VIEN
CREATE OR REPLACE FUNCTION GIOLAMVIEC(month_out LUONG.THANG%TYPE, year_out LUONG.NAM%TYPE, mtk LUONG.MATK%TYPE)
RETURN NUMBER
AS 
   sogiolam NUMBER;
BEGIN
   SELECT SUM(SOGIOLAM) INTO sogiolam
   FROM CHAMCONG
   WHERE EXTRACT(MONTH FROM KETTHUC) = month_out
   AND EXTRACT(YEAR FROM KETTHUC) = year_out
   AND MATK = mtk;
   RETURN sogiolam;
   EXCEPTION 
       WHEN NO_DATA_FOUND THEN
           DBMS_OUTPUT.PUT_LINE('KHONG TIM THAY NHAN VIEN');
END;
/
DROP TRIGGER LUONG_INSERT;
DROP TRIGGER TINHLUONGNV;
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
/



