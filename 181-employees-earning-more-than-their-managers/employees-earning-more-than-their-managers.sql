# Write your MySQL query statement below

select e.name as Employee
from Employee as e join
Employee as f on e.managerId=f.id
where e.salary>f.salary;