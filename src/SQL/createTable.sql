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
  SLHIENCO NUMBER DEFAULT 0,
  ANHSACH NVARCHAR2(255) NOT NULL,
  GIATIEN NUMBER NOT NULL
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
  TONGTIENHD NUMBER DEFAULT 0
);

CREATE TABLE CTHD(
  MAHD NUMBER NOT NULL,
  MASACH NUMBER NOT NULL,
  SOLUONGMUATUNGCUONSACH NUMBER NOT NULL,
  CONSTRAINT PK_CTHD PRIMARY KEY (MAHD, MASACH) 
);

CREATE TABLE PHIEUNHAPSACH(
  MAPNS NUMBER NOT NULL PRIMARY KEY,
  MANPP NUMBER NOT NULL,
  MATK NUMBER NOT NULL,
  NGAYNHAPSACH DATE NOT NULL,
  TONGTIENNHAPSACH NUMBER DEFAULT 0
);
 
CREATE TABLE CTPNSACH(
  MAPNS NUMBER NOT NULL,
  MASACH NUMBER NOT NULL,
  SOLUONGNHAPTUNGCUONSACH NUMBER NOT NULL,
  GIASACHNHAP NUMBER NOT NULL,
  CONSTRAINT PK_CTPN  PRIMARY KEY (MAPNS, MASACH)
);

CREATE TABLE NHAPHANPHOI(
  MANPP NUMBER NOT NULL  PRIMARY KEY,
  TENNPP NVARCHAR2(100)  NOT NULL,
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
ALTER TABLE PHIEUNHAPSACH ADD CONSTRAINT FK_PN1S FOREIGN KEY(MANPP) REFERENCES NHAPHANPHOI(MANPP);
ALTER TABLE PHIEUNHAPSACH ADD CONSTRAINT FK_PNS2 FOREIGN KEY(MATK) REFERENCES TAIKHOAN(MATK);
ALTER TABLE CTPNSACH ADD CONSTRAINT FK_CTPNS1 FOREIGN KEY(MAPNS) REFERENCES PHIEUNHAPSACH(MAPNS);
ALTER TABLE CTPNSACH ADD CONSTRAINT FK_CTPNS2 FOREIGN KEY(MASACH) REFERENCES SACH(MASACH);
ALTER TABLE LUONG ADD CONSTRAINT FK_L FOREIGN KEY(MATK) REFERENCES TAIKHOAN(MATK);
ALTER TABLE CHAMCONG ADD CONSTRAINT FK_CC FOREIGN KEY(MATK) REFERENCES TAIKHOAN(MATK);

-----------------
ALTER TABLE KHACHHANG
ADD CCCD NVARCHAR2(15) NOT NULL;

COMMIT;


