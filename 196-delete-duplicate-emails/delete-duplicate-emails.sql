# Write your MySQL query statement below
delete c from Person as c join Person as d on c.email = d.email and c.id > d.id