use case_study_db;

drop function if exists func_1;

delimiter //
create function func_1()
returns int
DETERMINISTIC
begin
	declare ket_qua int default 0;
	select count(id_dich_vu)
    into ket_qua
	from dich_vu
    where id_dich_vu in (select hd.id_dich_vu 
			from hop_dong hd
			join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
			join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
			join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
			having sum(dv.chi_phi_thue+ hdct.so_luong* dvdk.gia) >= 2000);
    return ket_qua;
end //
delimiter ;
select func_1() as so_luong ;


drop function if exists func_2;
delimiter //
create function func_2(id_khach_hang int)
returns int
DETERMINISTIC
begin
	declare max_time int default 0;
    set max_time = (select max(datediff(hd.ngay_ket_thuc, hd.ngay_lam_hop_dong))
					from hop_dong hd
					where hd.id_khach_hang = id_khach_hang
                    );
    return max_time;
end //
delimiter ;
select func_2(2) as max_time; 