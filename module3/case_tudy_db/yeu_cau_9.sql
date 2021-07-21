use case_study_db;

select month(hd.ngay_lam_hop_dong) as thang, sum(dv.chi_phi_thue+hdct.so_luong* dvdk.gia) as doanh_thu
from hop_dong hd
join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
where  year(hd.ngay_lam_hop_dong) =2019
group by thang;

