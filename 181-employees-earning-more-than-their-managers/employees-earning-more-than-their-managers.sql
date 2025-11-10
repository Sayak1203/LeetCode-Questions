# Write your MySQL query statement below
select e.name as Employee from Employee as e where e.salary > (select f.salary from Employee as f where f.id = e.managerId); 