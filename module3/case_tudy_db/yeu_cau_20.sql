use case_study_db;

select  id_nhan_vien, ho_ten, email, sdt, ngay_sinh, dia_chi
from nhan_vien 
union all
select id_khach_hang, ho_ten, email, sdt, ngay_sinh, dia_chi
from khach_hang