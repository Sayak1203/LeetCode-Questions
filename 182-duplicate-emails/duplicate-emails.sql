# Write your MySQL query statement below
select distinct e.email as Email
from Person as e join Person as f 
where e.email = f.email and e.id!=f.id;