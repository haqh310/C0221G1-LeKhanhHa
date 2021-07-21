use case_study_db;

select  nv.id_nhan_vien, nv.ho_ten, td.trinh_do, bp.ten_bo_phan, nv.sdt, nv.dia_chi
from nhan_vien nv
join bo_phan bp  on nv.id_bo_phan = bp.id_bo_phan
join trinh_do td on nv.id_trinh_do = td.id_trinh_do
join hop_dong  hd on nv.id_nhan_vien = hd.id_nhan_vien
where hd.id_nhan_vien in (select id_nhan_vien
						from hop_dong
                        where year(ngay_lam_hop_dong) between 2018 and 2019)
group by hd.id_nhan_vien
having count(hd.id_nhan_vien) <= 3;