create database quan_ly_hang_hoa;
use quan_ly_hang_hoa;

create table phieu_xuat(
	so_px int auto_increment primary key,
    ngay_xuat date
);

create table vat_tu(
	ma_vat_tu int auto_increment primary key,
    ten_vat_tu varchar(45)
);

create table chi_tiet_phieu_xuat(
	so_px int not null,
    ma_vat_tu int not null,
    don_gia double,
    so_luong int,
    primary key(so_px,ma_vat_tu),
    foreign key (so_px) references phieu_xuat(so_px),
    foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table phieu_nhap(
	so_pn int auto_increment primary key,
    ngay_nhap date
);

create table chi_tiet_phieu_nhap(
	so_pn int not null,
    ma_vat_tu int not null,
	don_gia double,
    so_luong int,
    primary key(so_pn,ma_vat_tu),
    foreign key (so_pn) references phieu_nhap(so_pn),
    foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table so_dien_thoai(
	so_dt varchar(10) primary key,
    ngay_het_han date
);

create table nha_cc(
	ma_nha_cc int auto_increment primary key,
    ten_nha_cc varchar(45),
    dia_chi varchar(45),
    so_dt varchar(45) not null,
    foreign key(so_dt) references so_dien_thoai(so_dt)
    
);

create table don_dh(
	so_dh int auto_increment primary key,
    ngay_dh date,
    ma_nha_cc int not null,
    foreign key (ma_nha_cc) references nha_cc(ma_nha_cc)
);

create table chi_tiet_don_dat_hang(
	so_dh int not null,
	ma_vat_tu int not null,
    primary key(so_dh,ma_vat_tu),
	foreign key(so_dh) references don_dh(so_dh),
	foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);



