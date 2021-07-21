use case_study_db;

DELIMITER //
create procedure sp_1
	(in id_khach_hang int)
begin
	delete from khach_hang kh
    where kh.id_khach_hang = id_khach_hang;
end //
DELIMITER ;

call sp_1(4);