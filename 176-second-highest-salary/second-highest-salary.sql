with cte as(
    select
    *,
    dense_rank() over (order by salary desc) as dr,
    row_number() over (partition by salary order by salary desc) as rn
    from Employee
)
select
coalesce((select salary from cte where dr=2 and rn=1),null) as SecondHighestSalary;