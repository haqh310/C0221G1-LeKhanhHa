USE QuanLySinhVien;

select *
from student
where StudentName like "h%";

select *
from class
where month(StartDate) =12;


select * 
from subject
where Credit between 3 and 5;

update student
set ClassID = 2
where StudentName="Hung";

select s.StudentName, sub.SubName, m.*
from student s join mark m on s.StudentId = m.StudentId 
join subject sub on m.SubId = sub.SubId
order by m.Mark desc, s.StudentName asc;
