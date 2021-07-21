use case_study_db;

select * 
from dich_vu dv
join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
join loai_khach_hang lkh on kh.id_loai_khach_hang = lkh.id_loai_khach_hang
where lkh.ten_loai_khach_hang="Diamond"  and kh.dia_chi in ("Vinh","Quảng Ngãi")
group by dv.ten_dich_vu