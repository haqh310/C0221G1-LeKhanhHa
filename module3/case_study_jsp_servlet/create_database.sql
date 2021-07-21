use case_study_2;

create table contract_detail(
	contract_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    contract_id INT NOT NULL,
    attach_service_id INT NOT NULL,
    quantity INT,
    FOREIGN KEY (contract_id) REFERENCES contract(contract_id),
    FOREIGN KEY (attach_service_id) REFERENCES attach_service(attach_service_id)
);
INSERT INTO `position`(position_name)
VALUES ("lễ tân"),
	("phục vụ"),
	("chuyên viên"),
	("giám sát"),
	("quản lý"),
    ("giám đốc");
    
insert into education_degree(education_degree_name)
values ("trung cấp"),
	("cao đẳng"),
	("đại học"),
    ("sau đại học");
    
insert into division(division_name)
values ("sale – marketing"),
	("hành chính"),
    ("phục vụ"),
    ("quản lý");

insert into user(username, password)
values ("haqh310", "123456"),
 ("toandang", "123456"),
 ("namphuong", "123456");

insert into employee(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username)
values ("ha","1999-10-03","123456",1500,"0983470724","haqh310@gmail.com","quangbinh",3,2,2,"haqh310"),
	("toan","1996-08-15","123457",1900,"0983470725","toandang@gmail.com","danang",1,2,1,"toandang"),
	("nam","1999-02-20","123458",2000,"0983470726","namphuong@gmail.com","danang",1,1,2,"namphuong");
 
insert into customer_type(customer_type_name)
values ("Diamond"),
	("Platinium"),
	("Gold"),
	("Silver"),
    ("Member");
    
insert into customer(customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)
values (1,"khanhha","1999-10-03","Male","125478","0983123456","haqh310@gmail.com","quangbinh"),
		(2,"nam","1999-06-17","Male","587249","0983123456","khanhnam@gmail.com","danang");
        
insert into service_type(service_type_name)
values ("Villa"), 
("House"),
( "Room");

insert into rent_type(rent_type_name, rent_type_cost)
values ("year", 15000),
	("month", 2000),
    ("day", 500),
    ("hours", 100);
    
insert into service(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors)
values ("room1",50,1500,2,3,1,"cao cap","nuoc uong",20,1),
 ("house1",150,8000,5,2,2,"thuong","phong bep",60,1),
 ("villa1",300,15000,10,1,1,"vip","phong tap",120,3);
 
 insert into service(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors)
values ("room1",50,1500,2,3,1,"cao cap","nuoc uong",null, null);


 insert into attach_service (attach_service_name,attach_service_cost,attach_service_unit,attach_service_status)
 values("massage",1500,5,"chuyen nghiep"),
	("karaoke",2000,3,"phong lanh"),
    ("food",700,10,"24/24");
 
 
 delimiter //
 create procedure select_customer_contract()
 begin
	select ct.contract_id, c.customer_name,e.employee_name,s.service_name, group_concat(DISTINCT ats.attach_service_name SEPARATOR ', ') as attach_service_name ,ct.contract_total_money,ct.contract_start_date, ct.contract_end_date
	from contract ct
	join customer c on ct.customer_id = c.customer_id
	join employee e on ct.employee_id = e.employee_id
	join service s on ct.service_id = s.service_id
    left join contract_detail cd on ct.contract_id = cd.contract_id
    left join attach_service ats on cd.attach_service_id = ats.attach_service_id
      group by ct.contract_id;
end //
delimiter ;


 delimiter //
 create procedure select_contract_by_name(customer_name varchar(45))
 begin
	select ct.contract_id, c.customer_name,e.employee_name,s.service_name, group_concat(DISTINCT ats.attach_service_name SEPARATOR ', ') as attach_service_name ,ct.contract_total_money,ct.contract_start_date, ct.contract_end_date
	from contract ct
	join customer c on ct.customer_id = c.customer_id
	join employee e on ct.employee_id = e.employee_id
	join service s on ct.service_id = s.service_id
    left join contract_detail cd on ct.contract_id = cd.contract_id
    left join attach_service ats on cd.attach_service_id = ats.attach_service_id
    where c.customer_name like concat('%',customer_name,'%')
	group by ct.contract_id;
end //
delimiter ;

call select_contract_by_name("kha");

delimiter //
create procedure total_money
	(contract_id int)
begin
	 select ifnull(s.service_cost + sum(ats.attach_service_cost * cd.quantity),s.service_cost ) as total_money
	from contract ct
	join service s on ct.service_id = s.service_id
	left join contract_detail cd on  ct.contract_id = cd.contract_id
	left join attach_service ats on cd.attach_service_id = ats.attach_service_id
	where ct.contract_id = contract_id;
end //
delimiter ;


alter table contract_detail
drop constraint contract_detail_ibfk_1;

alter table contract_detail
add constraint contract_detail_ibfk_1 FOREIGN KEY (contract_id) REFERENCES contract(contract_id)
on delete cascade;

update contract_detail
set attach_service_id = 2, quantity=3
where contract_detail_id =1;

alter table customer
add customer_code varchar(45) not null;

alter table service
add service_code varchar(45) not null;