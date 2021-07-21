use case_study_db;

alter table hop_dong
drop constraint hop_dong_ibfk_2;

alter table hop_dong
add constraint hop_dong_ibfk_2 FOREIGN KEY (id_khach_hang) REFERENCES khach_hang(id_khach_hang)
on delete cascade;

delete kh
from khach_hang kh
join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
where kh.id_khach_hang not in (
	select id_khach_hang
    from hop_dong 
    where year(ngay_lam_hop_dong) >= 2016
    group by id_khach_hang)

