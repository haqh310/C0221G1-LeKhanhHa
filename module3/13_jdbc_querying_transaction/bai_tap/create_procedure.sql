use demo;

delimiter //
create procedure select_all_user()
begin
	select * from users;
end 
// delimiter ;

delimiter //
create procedure update_user_by_id
	( name varchar(120),
    email varchar(220),
    country varchar(120),
    id int)
begin
	update users u
    set u.`name` = `name`, u.email = email, u.country = country
    where u.id = id;
end 
// delimiter ;

delimiter //
create procedure delete_user_by_id
	( id int)
begin
	delete from users u
    where u.id = id;
end 
// delimiter ;

select *
from users
where name like '%a%';

call select_all_user();
call update_user_by_id();
call delete_user_by_id();