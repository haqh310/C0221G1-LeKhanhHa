use case_study_db;

update dich_vu_di_kem dvdk
set gia = dvdk.gia *2
where  (select dvdk.id_dich_vu_di_kem
from hop_dong_chi_tiet hdct 
join hop_dong hd on hdct.id_hop_dong = hd.id_hop_dong
where dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem and year(hd.ngay_lam_hop_dong) =2019
group by hdct.id_dich_vu_di_kem 
having sum(hdct.so_luong) >10);

