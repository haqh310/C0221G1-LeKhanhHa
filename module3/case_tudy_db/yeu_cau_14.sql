use case_study_db;

select hd.id_hop_dong, dv.ten_dich_vu, dvdk.ten_dich_vu_di_kem, hdct.so_luong
from hop_dong hd
join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
group by hdct.id_dich_vu_di_kem
having sum(hdct.so_luong)=1;