set serveroutput on;
-------------------------INSERT, UPDATE, DELETE--------------------------------------------
--TAIKHOAN
CREATE OR REPLACE PROCEDURE ThemTK(dn IN TAIKHOAN.TENDN%TYPE, mk IN TAIKHOAN.MATKHAU%TYPE, hten IN TAIKHOAN.HOTEN%TYPE, ngsinh IN TAIKHOAN.NGAYSINH%TYPE,  dc IN TAIKHOAN.DIACHI%TYPE, sdttk IN TAIKHOAN.SDT%TYPE, gm IN TAIKHOAN.GMAIL%TYPE, cv IN TAIKHOAN.CHUCVU%TYPE, ngtao IN TAIKHOAN.NGAYTAOTAIKHOAN%TYPE, tienluong IN TAIKHOAN.LUONG%TYPE)
AS
BEGIN 
        INSERT INTO TAIKHOAN(MATK, TENDN, MATKHAU, HOTEN, NGAYSINH, DIACHI, SDT, GMAIL, NGAYTAOTAIKHOAN, CHUCVU, LUONG) VALUES (SQ_TK.NEXTVAL, dn, mk, hten, ngsinh, dc, sdttk, gm, ngtao, cv, tienluong);
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE SuaTK(mtk IN TAIKHOAN.MATK%TYPE, hten IN TAIKHOAN.HOTEN%TYPE, ngsinh IN TAIKHOAN.NGAYSINH%TYPE,  dc IN TAIKHOAN.DIACHI%TYPE, sdttk IN TAIKHOAN.SDT%TYPE, gm IN TAIKHOAN.GMAIL%TYPE, cv IN TAIKHOAN.CHUCVU%TYPE, tienluong IN TAIKHOAN.LUONG%TYPE)
AS
BEGIN 
       UPDATE TAIKHOAN 
       SET HOTEN = hten,
       NGAYSINH = ngsinh,
       DIACHI = dc,
       SDT = sdttk,
       GMAIL = gm,
       CHUCVU = cv,
       LUONG = tienluong
       WHERE MATK = mtk;
       COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE XoaTK(mtk IN TAIKHOAN.MATK%TYPE)
AS
BEGIN 
       DELETE FROM TAIKHOAN WHERE MATK = mtk;
       COMMIT;
END;
/

--KHACHHANG
CREATE OR REPLACE PROCEDURE ThemKH(hten IN KHACHHANG.HOTEN%TYPE, ngsinh IN KHACHHANG.NGAYSINH%TYPE,  dc IN KHACHHANG.DIACHI%TYPE, sdtkh IN KHACHHANG.SDT%TYPE, gtinh IN KHACHHANG.GIOITINH%TYPE,  cccdkh IN KHACHHANG.CCCD%TYPE)
AS
BEGIN 
        INSERT INTO KHACHHANG(MAKH, HOTEN, NGAYSINH, SDT, DIACHI, CCCD, GIOITINH) VALUES (SQ_KH.NEXTVAL, hten, ngsinh, sdtkh, dc, cccdkh , gtinh);
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE SuaKH(mkh IN KHACHHANG.MAKH%TYPE,hten IN KHACHHANG.HOTEN%TYPE, ngsinh IN KHACHHANG.NGAYSINH%TYPE,  dc IN KHACHHANG.DIACHI%TYPE, sdtkh IN KHACHHANG.SDT%TYPE, gtinh IN KHACHHANG.GIOITINH%TYPE,  cccdkh IN KHACHHANG.CCCD%TYPE)
AS
BEGIN 
       UPDATE KHACHHANG
       SET HOTEN = hten,
       NGAYSINH = ngsinh,
       DIACHI = dc,
       SDT = sdtkh,
       CCCD = cccdkh,
       GIOITINH = gtinh
       WHERE MAKH = mkh;
       COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE XoaKH(mkh IN KHACHHANG.MAKH%TYPE)
AS
BEGIN 
        DELETE FROM KHACHHANG WHERE MAKH = mkh;
        COMMIT;
END;
/

--SACH
CREATE OR REPLACE PROCEDURE ThemSACH(ts IN SACH.TENSACH%TYPE, tg IN SACH.TENTG%TYPE, nxbs IN SACH.NXB%TYPE, mtl IN SACH.MATL%TYPE, sl IN SACH.SLHIENCO%TYPE, anh IN SACH.ANHSACH%TYPE,  gia IN SACH.GIATIEN%TYPE)
AS
BEGIN 
        INSERT INTO SACH(MASACH, TENSACH, TENTG, NXB, MATL, SLHIENCO, ANHSACH, GIATIEN) VALUES (SQ_S.NEXTVAL, ts, tg, nxbs, mtl, sl, anh, gia);
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE SuaSACH(ms SACH.MASACH%TYPE,ts IN SACH.TENSACH%TYPE, tg IN SACH.TENTG%TYPE, nxbs IN SACH.NXB%TYPE, mtl IN SACH.MATL%TYPE, sl IN SACH.SLHIENCO%TYPE, anh IN SACH.ANHSACH%TYPE,  gia IN SACH.GIATIEN%TYPE)
AS
BEGIN 
        UPDATE SACH
        SET TENSACH = ts,
         TENTG = tg,
         NXB = nxbs,
         MATL = mtl,
         SLHIENCO = sl,
         ANHSACH = anh,
         GIATIEN  = gia
         WHERE MASACH = ms;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE XoaSACH(ms IN SACH.MASACH%TYPE)
AS
BEGIN 
        DELETE FROM SACH WHERE MASACH = ms;
        COMMIT;
END;
/

--HOADON
CREATE OR REPLACE PROCEDURE ThemHD(mkh IN HOADON.MAKH%TYPE, mtk IN HOADON.MATK%TYPE)
AS 
BEGIN
       INSERT INTO HOADON(MAHD, MAKH, MATK) VALUES (SQ_HD.NEXTVAL, mkh, mtk);
       COMMIT;
END;
/
---PHIEUNHAPSACH
CREATE OR REPLACE PROCEDURE ThemPNS(npp IN PHIEUNHAPSACH.MANPP%TYPE, mtk IN PHIEUNHAPSACH.MATK%TYPE)
AS 
BEGIN
       INSERT INTO PHIEUNHAPSACH(MAPNS, MANPP, MATK) VALUES (SQ_PNS.NEXTVAL, npp, mtk);
       COMMIT;
END;
/

--NHAPHANPHOI
CREATE OR REPLACE PROCEDURE ThemNPP(ten IN NHAPHANPHOI.TENNPP%TYPE, dc IN NHAPHANPHOI.DIACHI%TYPE, sdtnpp IN NHAPHANPHOI.SDT%TYPE)
AS
BEGIN 
        INSERT INTO NHAPHANPHOI(MANPP, TENNPP, DIACHI, SDT) VALUES (SQ_NPP.NEXTVAL, ten, dc, sdtnpp);
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE SuaNPP_FIX(ma IN NHAPHANPHOI.MANPP%TYPE, ten IN NHAPHANPHOI.TENNPP%TYPE, dc IN NHAPHANPHOI.DIACHI%TYPE, sdtnpp IN NHAPHANPHOI.SDT%TYPE)
AS
BEGIN 
        UPDATE NHAPHANPHOI
        SET TENNPP = ten,
        DIACHI = dc,
        SDT = sdtnpp
        WHERE MANPP = ma;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE XoaNPP(ma IN NHAPHANPHOI.MANPP%TYPE)
AS
BEGIN 
        DELETE FROM NHAPHANPHOI
        WHERE MANPP = ma;
        COMMIT;
END;
/
--THELOAI
CREATE OR REPLACE PROCEDURE ThemTL(tentl IN THELOAI.TENTHELOAI%TYPE)
AS
BEGIN 
        INSERT INTO THELOAI(MATL, TENTHELOAI) VALUES (SQ_TL.NEXTVAL, tentl);
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE SuaTL(mtl IN THELOAI.MATL%TYPE, tentl IN THELOAI.TENTHELOAI%TYPE)
AS
BEGIN 
        UPDATE THELOAI
        SET TENTHELOAI = tentl
        WHERE MATL = mtl;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE XoaTL(mtl IN THELOAI.MATL%TYPE)
AS
BEGIN 
        DELETE FROM THELOAI WHERE MATL = mtl;
        COMMIT;
END;
/

---CHI TIET HOA DON
CREATE OR REPLACE PROCEDURE ThemCTHD(mhd IN CTHD.MAHD%TYPE, ms IN CTHD.MASACH%TYPE, sl IN CTHD.SOLUONGMUATUNGCUONSACH%TYPE)
AS
BEGIN 
       INSERT INTO CTHD(MAHD, MASACH, SOLUONGMUATUNGCUONSACH) VALUES (mhd, ms, sl);
       COMMIT;
END;
/

--CHI TIET PHIEU NHAP
CREATE OR REPLACE PROCEDURE ThemCTPNSACH(mpns IN CTPNSACH.MAPNS%TYPE, ms IN CTPNSACH.MASACH%TYPE, sl IN CTPNSACH.SOLUONGNHAPTUNGCUONSACH%TYPE, gia IN CTPNSACH.GIASACHNHAP%TYPE)
AS
BEGIN 
       INSERT INTO CTPNSACH(MAPNS, MASACH,  SOLUONGNHAPTUNGCUONSACH,  GIASACHNHAP) VALUES (mpns, ms, sl, gia);
       COMMIT;
END;
/

--CHAM CONG
CREATE OR REPLACE PROCEDURE ThemCCONG(mtk IN CHAMCONG.MATK%TYPE)
AS
BEGIN
       INSERT INTO CHAMCONG(MATK) VALUES (mtk);
       COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE SUAKETTHUCCCong(mtk IN CHAMCONG.MATK%TYPE)
AS
    kt CHAMCONG.KETTHUC%TYPE;
BEGIN
    SELECT SYSDATE INTO kt FROM DUAL;
    
    UPDATE CHAMCONG
    SET KETTHUC = kt
    WHERE MATK = mtk
    AND TO_DATE(TO_CHAR(kt, 'DD-MM-YYYY'), 'DD-MM-YYYY') = TO_DATE(TO_CHAR(BATDAULAM, 'DD-MM-YYYY'), 'DD-MM-YYYY');
    COMMIT;
END;
/
---LUONG
CREATE OR REPLACE PROCEDURE ThemLUONGNV(month_out IN LUONG.THANG%TYPE, year_out IN LUONG.NAM%TYPE, mtk IN LUONG.MATK%TYPE)
AS
BEGIN
       INSERT INTO LUONG(THANG, NAM, MATK) VALUES (month_out, year_out, mtk);
       COMMIT;
END;




-----------------GET DU LIEU ------------------------
--TAIKHOAN
CREATE OR REPLACE PROCEDURE GETTCTK(out_cur OUT SYS_REFCURSOR)
AS
BEGIN 
        OPEN out_cur FOR
        SELECT * FROM TAIKHOAN;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETTKTHEOMA(mtk IN TAIKHOAN.MATK%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN 
        OPEN out_cur FOR
        SELECT * FROM TAIKHOAN
        WHERE MATK = mtk;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETTKTHEOTEN(hten IN TAIKHOAN.HOTEN%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN 
        OPEN out_cur FOR
        SELECT * FROM TAIKHOAN
        WHERE HOTEN =  hten;
        COMMIT;
END;
/

--KHACH HANG
CREATE OR REPLACE PROCEDURE GETTCKH(out_cur OUT SYS_REFCURSOR)
AS
BEGIN 
        OPEN out_cur FOR
        SELECT * FROM KHACHHANG;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETKHTHEOMA(mkh IN KHACHHANG.MAKH%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN 
        OPEN out_cur FOR
        SELECT * FROM KHACHHANG
        WHERE MAKH = mkh;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETKHTHEOTEN(hten IN  KHACHHANG.HOTEN%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN 
        OPEN out_cur FOR
        SELECT * FROM KHACHHANG
        WHERE HOTEN =  hten;
        COMMIT;
END;
/

----SACH
CREATE OR REPLACE PROCEDURE GETTCSACH(out_cur OUT SYS_REFCURSOR)
AS
BEGIN 
        OPEN out_cur FOR
        SELECT * FROM SACH;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETSACHTHEOMA(ms IN SACH.MASACH%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN 
        OPEN out_cur FOR
        SELECT SACH.*, THELOAI.* FROM SACH, THELOAI
        WHERE MASACH = ms
         AND SACH.MATL = THELOAI.MATL;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETSACHTHEOTEN(ts IN SACH.TENSACH %TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN 
        OPEN out_cur FOR
        SELECT SACH.*, THELOAI.* FROM SACH, THELOAI
        WHERE TENSACH =  ts
        AND SACH.MATL = THELOAI.MATL;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETSACHTHEOHD (mhd IN CTHD.MAHD%TYPE,  out_cur OUT SYS_REFCURSOR)
AS
BEGIN 
     OPEN out_cur FOR
     SELECT S.*, CT.*, TL.* FROM SACH S, CTHD CT, THELOAI TL
     WHERE S.MASACH = CT.MASACH
     AND S.MATL = TL.MATL
     AND CT.MAHD = mhd;
     COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETSACHTHEOPNS (mpns IN CTPNSACH.MAPNS%TYPE,  out_cur OUT SYS_REFCURSOR)
AS
BEGIN 
     OPEN out_cur FOR
     SELECT S.*, CT.*, TL.* FROM SACH S, CTPNSACH CT, THELOAI TL
     WHERE S.MASACH = CT.MASACH
     AND CT.MAPNS = mpns
     AND S.MATL = TL.MATL;
     COMMIT;
END;
/
---THELOAI
CREATE OR REPLACE PROCEDURE GETTCTL(out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM THELOAI;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETTLTHEOMA(mtl IN THELOAI.MATL%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM THELOAI
        WHERE MATL = mtl;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETTLTHEOTEN(ttl IN THELOAI.TENTHELOAI%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM THELOAI
        WHERE TENTHELOAI = ttl;
        COMMIT;
END;
/

---NHAPHANPHOI
CREATE OR REPLACE PROCEDURE GETTCNPP(out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM NHAPHANPHOI;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETNPPTHEOMA(mnpp IN NHAPHANPHOI.MANPP%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM NHAPHANPHOI
        WHERE MANPP = mnpp;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETNPPTHEOTEN(tnpp IN NHAPHANPHOI.TENNPP%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM NHAPHANPHOI
        WHERE TENNPP = tnpp;
        COMMIT;
END;
/

--HOADON
CREATE OR REPLACE PROCEDURE GETTCHD(out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM HOADON
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETHDTHEOMA (mhd IN HOADON.MAHD%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM HOADON
        WHERE MAHD = mhd;
        COMMIT;
END; 
/
CREATE OR REPLACE PROCEDURE GETTHANGHD(out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT DISTINCT(EXTRACT(MONTH FROM NGAYTAOHD)) FROM HOADON;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETNAMHD(out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT DISTINCT(EXTRACT(YEAR FROM NGAYTAOHD)) FROM HOADON;
        COMMIT;
END;
/

--PHIEUNHAPSACH
CREATE OR REPLACE PROCEDURE GETTCPNS(out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT PNS.*, NPP.*, TK.* FROM PHIEUNHAPSACH PNS, NHAPHANPHOI NPP, TAIKHOAN TK
        WHERE PNS.MANPP = NPP.MANPP
        AND PNS.MATK = TK.MATK;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETPNSTHEOMA(mpns IN PHIEUNHAPSACH.MAPNS%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN
        OPEN out_cur FOR 
        SELECT PNS.*, NPP.*, TK.* FROM PHIEUNHAPSACH PNS, NHAPHANPHOI NPP, TAIKHOAN TK
        WHERE PNS.MANPP = NPP.MANPP
        AND PNS.MATK = TK.MATK
        AND PNS.MAPNS = mpns;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETPNSTHEONV(mtk IN PHIEUNHAPSACH.MATK%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT PNS.*, NPP.*, TK.* FROM PHIEUNHAPSACH PNS, NHAPHANPHOI NPP, TAIKHOAN TK
        WHERE PNS.MANPP = NPP.MANPP
        AND PNS.MATK = TK.MATK
        AND TK.MATK = mtk;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETPNSTHEONPP(mnpp IN PHIEUNHAPSACH.MANPP%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT PNS.*, NPP.*, TK.* FROM PHIEUNHAPSACH PNS, NHAPHANPHOI NPP, TAIKHOAN TK
        WHERE PNS.MANPP = NPP.MANPP
        AND PNS.MATK = TK.MATK
        AND NPP.MANPP = mnpp;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETTHANGPNS(out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT DISTINCT(EXTRACT(MONTH FROM NGAYNHAPSACH)) FROM PHIEUNHAPSACH;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETNAMPNS(out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT DISTINCT(EXTRACT(YEAR FROM NGAYNHAPSACH)) FROM PHIEUNHAPSACH;
        COMMIT;
END;
/

---LUONG
CREATE OR REPLACE PROCEDURE GETTCLUONG( out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM LUONG;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETLUONGTHEONV(mtk IN LUONG.MATK%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM LUONG
        WHERE MATK = mtk;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETLUONGTHEOTHANG(month_out IN LUONG.THANG%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM LUONG
        WHERE THANG = month_out;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETLUONGTHEONAM(year_out IN LUONG.NAM%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM LUONG
        WHERE NAM = year_out;
        COMMIT;
END;
/

--CHAMCONG
CREATE OR REPLACE PROCEDURE GETCHAMCONG( out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM CHAMCONG;
        COMMIT;
END;
/
--CHI TIET PHIEU NHAP
CREATE OR REPLACE PROCEDURE GETCTPNSACHTHEOMA(mpns IN CTPNSACH.MAPNS%TYPE, out_cur OUT SYS_REFCURSOR)
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM CTPNSACH
        WHERE SOLUONGNHAPTUNGCUONSACH > 0
        AND MAPNS = mpns;
        COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE GET_DANG_NHAP(tdn IN TAIKHOAN.TENDN%TYPE, mk IN TAIKHOAN.MATKHAU%TYPE, out_cur OUT SYS_REFCURSOR) 
AS
BEGIN
       OPEN out_cur FOR 
        SELECT * FROM TAIKHOAN
        WHERE TENDN = tendn
        AND MATKHAU = mk;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GET_TL_CHO_SACH(out_cur OUT SYS_REFCURSOR)
AS 
BEGIN 
      OPEN out_cur FOR
      SELECT S.*, TL.* FROM SACH S, THELOAI TL
      WHERE S.MATL = TL.MATL;
      COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETMaHD(out_cur OUT SYS_REFCURSOR)
AS
BEGIN 
        OPEN out_cur FOR
        SELECT MAX(MAHD) FROM HOADON;
        COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE GETMaPNS(out_cur OUT SYS_REFCURSOR)
AS
BEGIN 
        OPEN out_cur FOR
        SELECT MAX(MAPNS) FROM PHIEUNHAPSACH;
        COMMIT;
END;
   













