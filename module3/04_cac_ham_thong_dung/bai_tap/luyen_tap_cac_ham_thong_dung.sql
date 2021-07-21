USE QuanLySinhVien;

select *
from subject sb
group by SubId,SubName
having sb.Credit >= all(select Credit from subject);

select sb.SubName,m.Mark
from subject sb
join mark m on sb.SubId = m.SubId
group by sb.SubName,m.Mark
having m.Mark >= all (select Mark from mark group by mark.SubId);



select s.StudentId,s.StudentName, avg(m.mark)
from Student s 
left join Mark m on s.StudentId = m.StudentId
group by m.StudentId
order by m.mark desc;
