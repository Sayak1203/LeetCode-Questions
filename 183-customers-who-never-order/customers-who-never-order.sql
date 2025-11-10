# Write your MySQL query statement below
select c.name as Customers from Customers as c left join orders as o on c.id = o.customerId where o.id is null

-- SELECT 
--     c.name as Customers
-- FROM
--     customers as c
-- LEFT JOIN
--     orders as o
--     ON o.customerId=c.id
-- WHERE
--     o.id is NULL