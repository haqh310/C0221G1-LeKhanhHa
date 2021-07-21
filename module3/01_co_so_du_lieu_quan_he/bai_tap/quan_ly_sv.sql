use `student-management`;
create table `class`(
 id int primary key auto_increment ,
 name varchar(255)
);
create table `student-management`.`teacher`(
 id int primary key auto_increment ,
 name varchar(255),
 age int,
 country varchar(255)
);

