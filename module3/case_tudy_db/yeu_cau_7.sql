use case_study_db;

select dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da ,dv.chi_phi_thue, ldv.ten_loai_dich_vu,hd.id_hop_dong
from dich_vu dv
join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
where year(hd.ngay_lam_hop_dong) = 2018
	and not exists (select ngay_lam_hop_dong 
					from hop_dong 
					where year(ngay_lam_hop_dong)=2019 
						and hd.id_dich_vu=id_dich_vu );
