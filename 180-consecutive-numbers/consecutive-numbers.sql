with cte as(
    select *,
    row_number() over (order by id)-row_number() over (partition by num order by id) as 'count'
    from Logs
)select distinct num as 'ConsecutiveNums' from cte 
group by num,count
having count(*)>=3 