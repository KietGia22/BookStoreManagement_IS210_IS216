--báo cáo t?n
CREATE TABLE BAOCAOTON
(
	MaBaoCao int not null PRIMARY KEY,
	Thang int,
	Nam int,
	MaSach int,
	TonDau int,
	PhatSinh int,
	TonCuoi int
);

alter table BAOCAOTON add foreign key (MaSach) references Sach(MaSach);

create sequence BCT_ID start with 1;
insert into BAOCAOTON(MaBaoCao, Thang, Nam, MaSach, TonDau, PhatSinh, TonCuoi) values (BCT_ID.nextval, 4,2023,1,40,-10,30);
insert into BAOCAOTON(MaBaoCao, Thang, Nam, MaSach, TonDau, PhatSinh, TonCuoi) values (BCT_ID.nextval, 4,2023,2,100,100,200);
insert into BAOCAOTON(MaBaoCao, Thang, Nam, MaSach, TonDau, PhatSinh, TonCuoi) values (BCT_ID.nextval, 4,2023,3,65,-15,50);
insert into BAOCAOTON(MaBaoCao, Thang, Nam, MaSach, TonDau, PhatSinh, TonCuoi) values (BCT_ID.nextval, 4,2023,4,100,30,130);
insert into BAOCAOTON(MaBaoCao, Thang, Nam, MaSach, TonDau, PhatSinh, TonCuoi) values (BCT_ID.nextval, 4,2023,5,105,-30,75);
insert into BAOCAOTON(MaBaoCao, Thang, Nam, MaSach, TonDau, PhatSinh, TonCuoi) values (BCT_ID.nextval, 4,2023,6,50,30,80);
insert into BAOCAOTON(MaBaoCao, Thang, Nam, MaSach, TonDau, PhatSinh, TonCuoi) values (BCT_ID.nextval, 4,2023,7,90,-40,50);
insert into BAOCAOTON(MaBaoCao, Thang, Nam, MaSach, TonDau, PhatSinh, TonCuoi) values (BCT_ID.nextval, 4,2023,8,100,50,150);
insert into BAOCAOTON(MaBaoCao, Thang, Nam, MaSach, TonDau, PhatSinh, TonCuoi) values (BCT_ID.nextval, 4,2023,9,120,-20,100);

--báo cáo doanh thu
CREATE TABLE BAOCAODOANHTHU
(
	MaBaoCao int not null PRIMARY KEY,
	Thang int,
	Nam int,
	MaSach int,
	GiaTien number,
	SoLuong int,
	TongTien number
);

alter table BAOCAODOANHTHU add foreign key (MaSach) references Sach(MaSach);
create sequence BCDT_ID start with 1;

COMMIT;

