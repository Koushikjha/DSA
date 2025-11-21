with cte as(
    select 
    *,
    sum(weight) over (order by turn) as s
    from Queue
)select person_name from cte where s<=1000 order by turn desc limit 1;