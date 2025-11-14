with clt as
(
    with cte as(
        select d.name as Department, e.name as Employee,e.salary as Salary from Employee e
        left join Department d
        on e.departmentid=d.id
    )
    select *,
    dense_rank() over (partition by Department order by salary desc) as dr
    from cte
)
select Department,Employee,Salary from clt where dr<=3;
    

