with cte as (
    select e.id,e.name,e.salary,d.name as 'deptName',dense_rank() over (partition by d.id order by e.salary desc) as rk from Employee e
    left join 
    Department d
    on e.departmentId=d.id
)select deptName as Department,name as 'Employee',salary as 'Salary' from cte where rk=1 order by id