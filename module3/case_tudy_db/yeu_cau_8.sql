use case_study_db;

select  DISTINCT ho_ten
from khach_hang;

select *
from khach_hang
group by ho_ten;

select ho_ten
from khach_hang
union
select ho_ten
from khach_hang; 

select *
from khach_hang kh1
where not exists(
	select ho_ten
    from khach_hang kh2
    where kh1.ho_ten = kh2.ho_ten and kh1.id_khach_hang < kh2.id_khach_hang
    );
    
