use case_study_db;

update khach_hang kh
set kh.id_loai_khach_hang = 1
where kh.id_loai_khach_hang =2 and
( select id_khach_hang
from hop_dong hd
join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
where hd.id_khach_hang = kh.id_khach_hang
group by hd.id_khach_hang
having sum(dv.chi_phi_thue+ hdct.so_luong* dvdk.gia) >= 5000);