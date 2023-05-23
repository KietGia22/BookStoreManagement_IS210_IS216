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