create database if not exists internship;

use internship;

create table faculty(
	faculty_id int auto_increment primary key,
    faculty_name char(30) not null,
    phone char(10) 
);

create table instructor(
	instructor_id int auto_increment primary key,
    instructor_name char(30) not null,
    salary double,
    faculty_id int,
    foreign key(faculty_id) references faculty(faculty_id)
);

create table student(
	student_id int auto_increment primary key,
    student_name char(40) not null,
     faculty_id int,
     date_of_birth date,
     place_of_birth char(30),
	foreign key(faculty_id) references faculty(faculty_id)
);

create table project(
	project_id int auto_increment primary key,
    project_name char(30) not null,
    expense int,
    place_of_intern char(30)
);

create table instructor_student(
	student_id int,
    project_id int,
    instructor_id int,
    grade double,
    primary key(student_id, project_id, instructor_id),
    foreign key(student_id) references student(student_id),
    foreign key(project_id) references project(project_id),
    foreign key(instructor_id) references instructor(instructor_id)
);

insert into faculty(faculty_name, phone)
values ("dia ly","0983125478"),
	("qltn","0983125468"),
	("toan","0983123456"),
	("cong nghe sinh hoc","0983125786");
    
insert into instructor(instructor_name, salary, faculty_id)
values("chanh",1500,"1"),
	("tien",1700,"2"),
	("chien",1200,"1"),
    ("tran son",1600,"2");
    
insert into student(student_name, faculty_id, date_of_birth, place_of_birth)
values ("ha", 1,"1999-10-03","quangbinh"),
	("toan",2,"1996-08-15","danang"),
    ("le van son",3,"1997-05-10","hanoi");
    
insert into project (project_name, expense, place_of_intern)
values ("tao database",1000,"danang"),
	("furamar",1500,"hue"),
	("tao trang web",1300,"hanoi");
    
insert into instructor_student
values (1,1,2,8),
	(2,2,1,7),
    (3,2,4,9);
    
-- 1.Đưa ra thông tin gồm mã số, họ tên và tên khoa của tất cả các giảng viên 
select i.instructor_id, i.instructor_name, f.faculty_name
from instructor i
left join faculty f on f.faculty_id = i.faculty_id;

-- 2. Đưa ra thông tin gồm mã số, họ tên và tên khoa của các giảng viên của khoa ‘DIA LY va QLTN’ 
select i.instructor_id, i.instructor_name, f.faculty_name
from instructor i
join faculty f on f.faculty_id = i.faculty_id
where f.faculty_name in ("dia ly", "qltn"); 

-- 3.Cho biết số sinh viên của khoa ‘CONG NGHE SINH HOC’
select f.faculty_name, count(*) as `so_luong` 
from faculty f
join student s on f.faculty_id = s.faculty_id
where f.faculty_name = "toan";

-- 4.Đưa ra danh sách gồm mã số, họ tên và tuổi của các sinh viên khoa ‘TOAN’
select s.student_id , s.student_name , year(now()) - year (s.date_of_birth) as `age` 
from student s
join faculty f on s.faculty_id = f.faculty_id
where f.faculty_name ="toan";

-- 5.Cho biết số giảng viên của khoa ‘CONG NGHE SINH HOC’
 select count(*) as `so_luong` 
from faculty f
join instructor i on f.faculty_id = i.faculty_id
where f.faculty_name = "cong nghe sinh hoc";

-- 6.Cho biết thông tin về sinh viên không tham gia thực tập
select s.*
from student s
left join instructor_student ins on s.student_id = ins.student_id
where ins.project_id is null;

-- 7.Đưa ra mã khoa, tên khoa và số giảng viên của mỗi khoa
select f.faculty_id, f.faculty_name , count(*) as `so_luong_gv`
from faculty f
left join instructor i on f.faculty_id = i.faculty_id
group by f.faculty_id;

-- 8.Cho biết số điện thoại của khoa mà sinh viên có tên ‘Le van son’ đang theo học
select f.phone
from faculty f
join student s on f.faculty_id = s.faculty_id
where s.student_name = "le van son" ;

-- 1.Cho biết mã số và tên của các đề tài do giảng viên ‘Tran son’ hướng dẫn
select p.project_id , p.project_name
from project p
join instructor_student ins on p.project_id = ins.project_id
join instructor i on ins.instructor_id = i.instructor_id
where i.instructor_name = "tran son";

-- 2.Cho biết tên đề tài không có sinh viên nào thực tập

select  p.project_name
from project p
left join instructor_student ins on p.project_id = ins.project_id
where ins.student_id is null;

-- 3.Cho biết mã số, họ tên, tên khoa của các giảng viên hướng dẫn từ 3 sinh viên trở lên

select i.instructor_id , i.instructor_name, f.faculty_name
from instructor i
join faculty f on i.faculty_id = f.faculty_id
join instructor_student ins on i.instructor_id = ins.instructor_id
group by ins.instructor_id
having count(ins.student_id) >=2;

-- 4.Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất
select p.project_id, p.project_name
from project p 
having max(p.expense);

-- 5.Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực tập

select p.project_id, p.project_name
from project p
join instructor_student ins on p.project_id = ins.project_id
group by ins.project_id
having count(ins.student_id) >= 2;


-- 6.Đưa ra mã số, họ tên và điểm của các sinh viên khoa ‘DIALY và QLTN’
select s.student_id, s.student_name, ins.grade
from student s
join faculty f on s.faculty_id = f.faculty_id
join instructor_student ins on s.student_id = ins.student_id
where f.faculty_name in ("dia ly" ,"qltn")
group by s.student_id;

-- 7.Đưa ra tên khoa, số lượng sinh viên của mỗi khoa
select f.faculty_name, count(*) as `so_luong_sv`
from faculty f
join student s on f.faculty_id = s.faculty_id
group by f.faculty_id;

-- 8.Cho biết thông tin về các sinh viên thực tập tại quê nhà
select s.*
from student s
join instructor_student ins on s.student_id = ins.student_id
join project p on ins.project_id = p.project_id
where s.place_of_birth = p.place_of_intern;

-- 9.Hãy cho biết thông tin về những sinh viên chưa có điểm thực tập
select s.*
from student s
join instructor_student ins on s.student_id = ins.student_id
where ins.grade is null;

-- 10. Đưa ra danh sách gồm mã số, họ tên các sinh viên có điểm thực tập bằng 0
select s.*
from student s
join instructor_student ins on s.student_id = ins.student_id
where ins.grade =0;
