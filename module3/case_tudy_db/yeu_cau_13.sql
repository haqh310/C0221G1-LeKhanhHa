use case_study_db;

select dvdk.ten_dich_vu_di_kem, dvdk.gia, dvdk.don_vi, sum(hdct.so_luong) as SL
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by hdct.id_dich_vu_di_kem
having sum(hdct.so_luong) >= all (select sum(so_luong) from hop_dong_chi_tiet group by id_dich_vu_di_kem)
