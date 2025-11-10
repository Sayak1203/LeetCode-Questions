# Write your MySQL query statement below
select c.id from Weather as c, Weather as d where datediff(c.recordDate, d.recordDate)=1 and c.temperature>d.temperature 