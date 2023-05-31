CREATE TABLE TAIKHOAN(
    MATK NUMBER NOT NULL PRIMARY KEY,
    TENDN VARCHAR(50) NOT NULL UNIQUE,
    MATKHAU VARCHAR(50) NOT NULL UNIQUE,
    HOTEN NVARCHAR2(100) NOT NULL,
    NGAYSINH DATE NOT NULL,
    DIACHI NVARCHAR2(100),
   	GMAIL NVARCHAR2(100),
    SDT NVARCHAR2(15) UNIQUE,
    CHUCVU NVARCHAR2(100) NOT NULL,
    LUONG NUMBER NOT NULL,
    NGAYTAOTAIKHOAN DATE NOT NULL
);

CREATE TABLE KHACHHANG( 
  MAKH NUMBER NOT NULL PRIMARY KEY,
  HOTEN NVARCHAR2(100)NOT NULL,
  NGAYSINH DATE NOT NULL,
  GIOITINH NVARCHAR2(10) NOT NULL,
  SDT NVARCHAR2(15) NOT NULL UNIQUE,
  DIACHI NVARCHAR2(100) NOT NULL,
  NGAYTAO DATE NOT NULL
);

CREATE TABLE SACH(
  MASACH NUMBER NOT NULL PRIMARY KEY,
  TENSACH NVARCHAR2(100) NOT NULL UNIQUE,
  TENTG NVARCHAR2(100), 
  NXB NVARCHAR2(100),
  MATL NUMBER NOT NULL,
  SLTON NUMBER DEFAULT 0,
  ANHSACH NVARCHAR2(255) NOT NULL,
  GIA NUMBER NOT NULL
);

CREATE TABLE THELOAI(
  MATL NUMBER NOT NULL PRIMARY KEY,
  TENTHELOAI NVARCHAR2(100) NOT NULL UNIQUE
);

CREATE TABLE HOADON(
  MAHD NUMBER NOT NULL PRIMARY KEY,
  MAKH NUMBER,
  MATK NUMBER NOT NULL,
  NGAYTAOHD DATE NOT NULL,
  TONGTIEN NUMBER DEFAULT 0
);

CREATE TABLE CTHD(
  MAHD NUMBER NOT NULL,
  MASACH NUMBER NOT NULL,
  SOLUONG NUMBER NOT NULL,
  CONSTRAINT PK_CTHD PRIMARY KEY (MAHD, MASACH) 
);

CREATE TABLE PHIEUNHAP(
  MAPN NUMBER NOT NULL PRIMARY KEY,
  MANCC NUMBER NOT NULL,
  MATK NUMBER NOT NULL,
  NGAYNHAP DATE NOT NULL,
  TONGTIENNHAP NUMBER DEFAULT 0
);
 
CREATE TABLE CTPN(
  MAPN NUMBER NOT NULL,
  MASACH NUMBER NOT NULL,
  SOLUONGNHAP NUMBER NOT NULL,
  GIANHAP NUMBER NOT NULL,
  CONSTRAINT PK_CTPN  PRIMARY KEY (MAPN, MASACH)
);

CREATE TABLE NHACUNGCAP(
  MANCC NUMBER NOT NULL  PRIMARY KEY,
  TENNCC NVARCHAR2(100)  NOT NULL,
  SDT NVARCHAR2(15) NOT NULL,
  DIACHI NVARCHAR2(100) NOT NULL
);

CREATE TABLE LUONG(
  THANG NUMBER NOT NULL,
  NAM NUMBER NOT NULL,
  MATK NUMBER NOT NULL,
  SOGIOLAM NUMBER DEFAULT 0,
  LUONG NUMBER(16, 2)  DEFAULT 0,
  CONSTRAINT PK_LUONG PRIMARY KEY (THANG, NAM, LUONG)
);

CREATE TABLE CHAMCONG(
  MATK NUMBER NOT NULL,
  BATDAULAM DATE NOT NULL,
  KETTHUC DATE NOT NULL,
  SOGIOLAM NUMBER(4,2) DEFAULT 0,
  CONSTRAINT PK_CC PRIMARY KEY (MATK, BATDAULAM)
);

---------------FOREIGN KEY
ALTER TABLE SACH ADD CONSTRAINT FK_SP FOREIGN KEY(MATL) REFERENCES THELOAI(MATL);
ALTER TABLE HOADON ADD CONSTRAINT FK_HD1 FOREIGN KEY(MAKH) REFERENCES KHACHHANG(MAKH);
ALTER TABLE HOADON ADD CONSTRAINT FK_HD2 FOREIGN KEY(MATK) REFERENCES TAIKHOAN(MATK);
ALTER TABLE  CTHD ADD CONSTRAINT FK_CTHD1 FOREIGN KEY(MAHD) REFERENCES HOADON(MAHD);
ALTER TABLE CTHD ADD CONSTRAINT FK_CTHD2 FOREIGN KEY(MASACH) REFERENCES SACH(MASACH);
ALTER TABLE PHIEUNHAP ADD CONSTRAINT FK_PN1 FOREIGN KEY(MANCC) REFERENCES NHACUNGCAP(MANCC);
ALTER TABLE PHIEUNHAP ADD CONSTRAINT FK_PN2 FOREIGN KEY(MATK) REFERENCES TAIKHOAN(MATK);
ALTER TABLE CTPN ADD CONSTRAINT FK_CTPN1 FOREIGN KEY(MAPN) REFERENCES PHIEUNHAP(MAPN);
ALTER TABLE CTPN ADD CONSTRAINT FK_CTPN2 FOREIGN KEY(MASACH) REFERENCES SACH(MASACH);
ALTER TABLE LUONG ADD CONSTRAINT FK_L FOREIGN KEY(MATK) REFERENCES TAIKHOAN(MATK);
ALTER TABLE CHAMCONG ADD CONSTRAINT FK_CC FOREIGN KEY(MATK) REFERENCES TAIKHOAN(MATK);

-----------------
ALTER TABLE KHACHHANG
ADD CCCD NVARCHAR2(15) NOT NULL;

ALTER TABLE TAIKHOAN
ADD CONSTRAINT unique_constraint_TAIKHOAN UNIQUE(TENDN, MATKHAU);



COMMIT;


