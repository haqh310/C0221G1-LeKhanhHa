use case_study_db;

drop view if exists v_nhan_vien;

create view v_nhan_vien as
select nv.* 
from nhan_vien nv
join hop_dong hd on nv.id_nhan_vien = hd.id_nhan_vien
where nv.dia_chi = "Hải Châu" and hd.ngay_lam_hop_dong="2019-12-12";


select * from v_nhan_vien;