use case_study_db;
    
select  dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu, hd.id_hop_dong
from dich_vu dv
	join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
	join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
where month(hd.ngay_lam_hop_dong) not in (1,2,3) 
	and year(hd.ngay_lam_hop_dong) =2021
	and  not exists(select ngay_lam_hop_dong
				from hop_dong
                where month(ngay_lam_hop_dong) in (1,2,3) and hd.id_dich_vu = id_dich_vu)
group by dv.id_dich_vu
