-- Tao database

CREATE DATABASE case_study_db;
USE case_study_db;


-- Tao bang

CREATE TABLE vi_tri (
	id_vi_tri INT AUTO_INCREMENT PRIMARY KEY,
    ten_vi_tri VARCHAR(45)
);
CREATE TABLE trinh_do(
	id_trinh_do INT AUTO_INCREMENT PRIMARY KEY,
    trinh_do VARCHAR(45)
);

CREATE TABLE bo_phan(
	id_bo_phan INT AUTO_INCREMENT PRIMARY KEY,
    ten_bo_phan VARCHAR(45)
);

CREATE TABLE nhan_vien(
	id_nhan_vien INT AUTO_INCREMENT PRIMARY KEY,
    ho_ten VARCHAR(45),
    id_vi_tri INT NOT NULL,
    id_trinh_do INT NOT NULL,
    id_bo_phan INT NOT NULL,
    ngay_sinh DATE NOT NULL,
    so_cmtnd VARCHAR(450),
    luong DOUBLE,
    sdt VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    FOREIGN KEY (id_vi_tri) REFERENCES vi_tri(id_vi_tri),
    FOREIGN KEY (id_trinh_do) REFERENCES trinh_do(id_trinh_do),
    FOREIGN KEY (id_bo_phan) REFERENCES bo_phan(id_bo_phan)
);

CREATE TABLE loai_khach_hang(
	id_loai_khach_hang INT AUTO_INCREMENT PRIMARY KEY,
    ten_loai_khach_hang VARCHAR(45)
);

CREATE TABLE khach_hang(
	id_khach_hang INT AUTO_INCREMENT PRIMARY KEY,
    id_loai_khach_hang INT NOT NULL,
    ho_ten VARCHAR(45),
    ngay_sinh DATE NOT NULL,
    so_cmtnd VARCHAR(45),
    sdt VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    FOREIGN KEY (id_loai_khach_hang) REFERENCES loai_khach_hang(id_loai_khach_hang)
);

CREATE TABLE kieu_thue(
	id_kieu_thue INT AUTO_INCREMENT  PRIMARY KEY,
    ten_kieu_thue VARCHAR(45),
    gia INT
);

CREATE TABLE loai_dich_vu(
	id_loai_dich_vu INT AUTO_INCREMENT PRIMARY KEY,
    ten_loai_dich_vu VARCHAR(45)
);


CREATE TABLE dich_vu(
	id_dich_vu INT AUTO_INCREMENT PRIMARY KEY,
    ten_dich_vu VARCHAR(45),
    dien_tich INT,
    so_tang INT,
    so_nguoi_toi_da VARCHAR(45),
    chi_phi_thue DOUBLE,
    id_kieu_thue INT NOT NULL,
	id_loai_dich_vu INT NOT NULL,
    trang_thai VARCHAR(45),
     FOREIGN KEY (id_kieu_thue) REFERENCES kieu_thue(id_kieu_thue),
     FOREIGN KEY (id_loai_dich_vu) REFERENCES loai_dich_vu(id_loai_dich_vu)
);

 CREATE TABLE dich_vu_di_kem(
		id_dich_vu_di_kem INT AUTO_INCREMENT PRIMARY KEY,
        ten_dich_vu_di_kem VARCHAR(45),
        gia INT,
        don_vi INT,
        trang_thai_kha_dung VARCHAR(45)
    );

CREATE TABLE  hop_dong(
	id_hop_dong INT AUTO_INCREMENT PRIMARY KEY,
    id_nhan_vien INT NOT NULL,
    id_khach_hang INT NOT NULL,
    id_dich_vu INT NOT NULL,
    ngay_lam_hop_dong DATE NOT NULL,
    ngay_ket_thuc DATE NOT NULL,
    tien_dat_coc INT,
    tong_tien INT,
    FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(id_nhan_vien),
    FOREIGN KEY (id_khach_hang) REFERENCES khach_hang(id_khach_hang),
    FOREIGN KEY (id_dich_vu) REFERENCES dich_vu(id_dich_vu)
);

CREATE TABLE hop_dong_chi_tiet(
	id_hop_dong_chi_tiet INT AUTO_INCREMENT PRIMARY KEY,
    id_hop_dong INT NOT NULL,
    id_dich_vu_di_kem INT NOT NULL,
    so_luong INT,
    FOREIGN KEY (id_hop_dong) REFERENCES hop_dong(id_hop_dong),
    FOREIGN KEY (id_dich_vu_di_kem) REFERENCES dich_vu_di_kem(id_dich_vu_di_kem)
    );
    
--  Them du lieu
 
INSERT INTO vi_tri(ten_vi_tri)
VALUES ("lễ tân"),
	("phục vụ"),
	("chuyên viên"),
	("giám sát"),
	("quản lý"),
    ("giám đốc");
    
insert into trinh_do(trinh_do)
values ("trung cấp"),
	("cao đẳng"),
	("đại học"),
    ("sau đại học");
    
insert into bo_phan(ten_bo_phan)
values ("sale – marketing"),
	("hành chính"),
    ("phục vụ"),
    ("quản lý");

insert into nhan_vien(ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,so_cmtnd,luong,sdt,email,dia_chi)
values ("ha",1,1,1,"1999-10-03","123456",10000,"0983123456","haqh310@gmail.com","QB"),
("toan",2,2,2,"1995-08-15","875146",6000,"0983123457","toandang@gmail.com","DN"),
("khanh",3,3,3,"1993-02-04","325789",80000,"0983123458","khanhphan@gmail.com","QB");

 
insert into loai_khach_hang(ten_loai_khach_hang)
values ("Diamond"),
	("Platinium"),
	("Gold"),
	("Silver"),
    ("Member");
    
insert into khach_hang(id_loai_khach_hang,ho_ten,ngay_sinh,so_cmtnd,sdt,email,dia_chi)
values (1,"khanhha","1999-10-03","125478","0983123456","haqh310@gmail.com","quangbinh"),
		(2,"nam","1999-06-17","587249","0983123456","khanhnam@gmail.com","danang");


insert into kieu_thue(ten_kieu_thue,gia)
values ("gio",500),
	("ngay",2000),
	("tuan",10000);
    
insert into loai_dich_vu(ten_loai_dich_vu)
values ("room"),
	("house"),
    ("villa");
    
insert into dich_vu(ten_dich_vu,dien_tich,so_tang,so_nguoi_toi_da,chi_phi_thue,id_kieu_thue,id_loai_dich_vu,trang_thai)
values ("room1",50,1,2,1000,1,1,"ok"),
	("house1",120,2,5,3000,2,2,"ss"),
    ("villa1",300,3,10,8000,3,3,"ban");

insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung)
values ("massage",1000,5,"tot"),
	("karaoke",1500,7,"ok"),
    ("thức ăn",2000,10,"co"),
    ("nước uống",1200,10,"co"),
    ("thuê xe",3000,10,"co");
    
insert into hop_dong (id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc)
values (1,1,1,"2021-05-12","2021-06-01",1000),
(2,2,2,"2021-05-11","2021-06-10",1500);


insert into hop_dong_chi_tiet(id_hop_dong,id_dich_vu_di_kem,so_luong)
values (1,1,5),
	(2,2,7);




