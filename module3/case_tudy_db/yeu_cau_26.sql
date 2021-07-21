use case_study_db;

delimiter //
create trigger tr_2
before update 
on hop_dong for each row
begin
	declare error_message varchar(255);
    set error_message = "Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày";
	if new.ngay_ket_thuc - old.ngay_lam_hop_dong <2 then 
		signal sqlstate "4500"
        set message_text=error_message;
	end if;
end //
delimiter ;