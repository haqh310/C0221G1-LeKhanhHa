use case_study_db;

select kh.id_khach_hang, kh.ho_ten, lkh.ten_loai_khach_hang, hd.id_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong,  hd.ngay_ket_thuc,sum(dv.chi_phi_thue+hdct.so_luong* dvdk.gia) as tong_tien
from hop_dong hd
	right join khach_hang kh  on hd.id_khach_hang = kh.id_khach_hang 
	join loai_khach_hang lkh  on kh.id_loai_khach_hang = lkh.id_loai_khach_hang
	join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
	join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
	join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
group by kh.id_khach_hang;
