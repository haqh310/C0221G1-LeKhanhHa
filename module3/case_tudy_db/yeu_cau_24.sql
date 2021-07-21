use case_study_db;

drop procedure if exists sp_2; 

DELIMITER //
create procedure sp_2
	(p_id_nhan_vien int, 
    p_id_khach_hang int, 
    p_id_dich_vu int, 
    p_ngay_lam_hop_dong date, 
    p_ngay_ket_thuc date, 
    p_tien_dat_coc int)
begin
	if (p_id_nhan_vien in (select id_nhan_vien from nhan_vien))
		and (p_id_khach_hang in (select id_khach_hang from khach_hang))
		and (p_id_dich_vu in (select id_dich_vu from dich_vu))
    then
		insert into hop_dong(id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc)
		values(p_id_nhan_vien, p_id_khach_hang, p_id_dich_vu, p_ngay_lam_hop_dong, p_ngay_ket_thuc, p_tien_dat_coc);
	else
		 SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = "Nhập sai dữ liệu";
	end if;
end //
DELIMITER ;

call sp_2(3,2,1,"2021-09-03","2021-11-03",1000);