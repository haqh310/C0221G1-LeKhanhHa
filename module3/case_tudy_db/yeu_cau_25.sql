use case_study_db;

delimiter //
create trigger tr_1
after delete 
on hop_dong for each row
begin
    declare so_luong int;
	 set so_luong = (select count(OLD.id_hop_dong) as so_luong
    from hop_dong);
    select concat("tổng số lượng bản ghi còn lại: ",so_luong) as log into outfile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/log.txt';
end //
delimiter ;

