----DROP TABLE 
DROP TABLE CHAMCONG;
DROP TABLE CTHD;
DROP TABLE CTPN;
DROP TABLE HOADON;
DROP TABLE KHACHHANG;
DROP TABLE LUONG;
DROP TABLE NHACUNGCAP;
DROP TABLE SACH;
DROP TABLE TAIKHOAN;
DROP TABLE THELOAI;
DROP TABLE PHIEUNHAP;

--DELETE FROM
DELETE FROM CHAMCONG;
DELETE FROM CTHD;
DELETE FROM CTPN;
DELETE FROM HOADON;
DELETE FROM KHACHHANG;
DELETE FROM LUONG;
DELETE FROM NHACUNGCAP;
DELETE FROM SACH;
DELETE FROM TAIKHOAN;
DELETE FROM THELOAI;
DELETE FROM PHIEUNHAP;

---DROP FK
ALTER TABLE SACH DROP CONSTRAINT FK_SP;
ALTER TABLE HOADON DROP CONSTRAINT FK_HD1;
ALTER TABLE HOADON DROP CONSTRAINT FK_HD2;
ALTER TABLE  CTHD DROP CONSTRAINT FK_CTHD1;
ALTER TABLE CTHD DROP CONSTRAINT FK_CTHD2;
ALTER TABLE PHIEUNHAP DROP CONSTRAINT FK_PN1;
ALTER TABLE PHIEUNHAP DROP CONSTRAINT FK_PN2;
ALTER TABLE CTPN DROP CONSTRAINT FK_CTPN1;
ALTER TABLE CTPN DROP CONSTRAINT FK_CTPN2;
ALTER TABLE LUONG DROP CONSTRAINT FK_L;
ALTER TABLE CHAMCONG DROP CONSTRAINT FK_CC;

ALTER TABLE KHACHHANG DROP CONSTRAINT CHECKKH;
ALTER TABLE KHACHHANG DROP CONSTRAINT CHECK_SDTKH;
ALTER TABLE KHACHHANG DROP CONSTRAINT CHECK_CCCD;
ALTER TABLE TAIKHOAN DROP CONSTRAINT CHECKTK;
ALTER TABLE TAIKHOAN DROP CONSTRAINT CHECKTUOI;
ALTER TABLE TAIKHOAN DROP CONSTRAINT CHECK_SDTTK;
ALTER TABLE TAIKHOAN DROP CONSTRAINT CHECK_CV;
ALTER TABLE SACH DROP CONSTRAINT CHECKSLTON;
ALTER TABLE NHACUNGCAP DROP CONSTRAINT CHECK_SDTNCC;
ALTER TABLE LUONG DROP CONSTRAINT CHECK_THANG;

------DROP SEQUENCE
DROP SEQUENCE SQ_TK;
DROP SEQUENCE SQ_S;
DROP SEQUENCE SQ_HD;
DROP SEQUENCE  SQ_TL;
DROP SEQUENCE SQ_NCC;
DROP SEQUENCE SQ_PN;
DROP SEQUENCE SQ_KH;

----DROP TRIGGER
DROP TRIGGER CTPN_INSERT_UPDATE;
DROP TRIGGER CTPN_DELETE;
DROP TRIGGER CTHD_INSERT_UPDATE;
DROP TRIGGER CTHD_DELETE;
DROP TRIGGER HOADON_CHECKNGAY;
DROP TRIGGER TAIKHOAN_CHECKNGAY;
DROP TRIGGER HOADON_CHECKNGAY_KH;
DROP TRIGGER KHACHHANG_CHECKNGAY;
DROP TRIGGER TAONGAY_HD;
DROP TRIGGER TAONGAY_KH;
DROP TRIGGER TAONGAY_PN;
DROP TRIGGER TAONGAY_BD;
DROP TRIGGER NO_UPDATE_CC;
DROP TRIGGER UPDATE_KETTHUC;
DROP TRIGGER LUONG_INSERT;

--PROCEDURE
DROP PROCEDURE ThemTK;
DROP PROCEDURE SuaTK;
DROP PROCEDURE XoaTK;
DROP PROCEDURE ThemKH;
DROP PROCEDURE SuaKH;
DROP PROCEDURE XoaKH;
DROP PROCEDURE ThemSACH;
DROP PROCEDURE SuaSACH;
DROP PROCEDURE XoaSACH;
DROP PROCEDURE ThemHD;
DROP PROCEDURE ThemPN;
DROP PROCEDURE ThemNCC;
DROP PROCEDURE ThemTL;
DROP PROCEDURE SuaTL;
DROP PROCEDURE XoaTL;
DROP PROCEDURE ThemCTHD;
DROP PROCEDURE ThemCTPN;
DROP PROCEDURE ThemCCong;
DROP PROCEDURE SUAKETTHUCCCong;
DROP PROCEDURE ThemLUONGNV;

DROP PROCEDURE GETTCTK;
DROP PROCEDURE GETTKTHEOMA;
DROP PROCEDURE GETTKTHEOTEN;
DROP PROCEDURE GETTCKH;
DROP PROCEDURE GETKHTHEOMA;
DROP PROCEDURE GETKHTHEOTEN;
DROP PROCEDURE GETTCSACH;
DROP PROCEDURE GETSACHTHEOMA;
DROP PROCEDURE GETSACHTHEOTEN;
DROP PROCEDURE GETSACHTHEOTL;
DROP PROCEDURE GETSACHTHEOHD;
DROP PROCEDURE GETTCTL;
DROP PROCEDURE GETTLTHEOMA;
DROP PROCEDURE GETTLTHEOTEN;
DROP PROCEDURE GETTCHD;
DROP PROCEDURE GETHDTHEOMA;
DROP PROCEDURE GETTHANGHD;
DROP PROCEDURE GETNAMHD;
DROP PROCEDURE GETTCPN;
DROP PROCEDURE GETPNTHEOMA;
DROP PROCEDURE GETPNTHEONV;
DROP PROCEDURE GETTHANGPN;
DROP PROCEDURE GETNAMPN;
DROP PROCEDURE GETTCNCC;
DROP PROCEDURE GETNCCTHEOMA;
DROP PROCEDURE GETNCCTHEOTEN;
DROP PROCEDURE GETTCLUONG;
DROP PROCEDURE GETLUONGTHEONV;
DROP PROCEDURE GETLUONGTHEOTHANG;
DROP PROCEDURE GETLUONGTHEONAM;
DROP PROCEDURE GETCHAMCONG;
DROP PROCEDURE GETCTPNTHEOMA;

--FUNCTION
DROP FUNCTION GET_DT_NAM;
DROP FUNCTION GET_DT_THANG;
DROP FUNCTION GET_NHAP_NAM;
DROP FUNCTION GET_NHAP_THANG;
DROP FUNCTION  GIOLAMVIEC;