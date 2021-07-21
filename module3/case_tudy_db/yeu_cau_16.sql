use case_study_db;

alter table  hop_dong 
drop constraint hop_dong_ibfk_1;

alter table  hop_dong
add constraint hop_dong_ibfk_1 foreign key (id_nhan_vien) REFERENCES nhan_vien(id_nhan_vien)
	on delete cascade;

alter table hop_dong_chi_tiet
drop constraint hop_dong_chi_tiet_ibfk_1;

alter table hop_dong_chi_tiet
add constraint hop_dong_chi_tiet_ibfk_1 FOREIGN KEY (id_hop_dong) REFERENCES hop_dong(id_hop_dong)
on delete cascade;

delete nv
	from nhan_vien nv
    join hop_dong hd on nv.id_nhan_vien = hd.id_nhan_vien
	where nv.id_nhan_vien not in
		(select id_nhan_vien
		from  hop_dong hd  
		where year(hd.ngay_lam_hop_dong) between 2017 and 2019
		group by hd.id_nhan_vien);
        