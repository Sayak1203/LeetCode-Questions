# Write your MySQL query statement below
select w.id from Weather as w join Weather as x on datediff(w.recordDate, x.recordDate)=1 where w.temperature>x.temperature;