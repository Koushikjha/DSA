with ste as
(
    with cte as(
    select 
    *,
    sum(weight) over (order by turn) as s
    from Queue
)
select *,
row_number() over(order by turn desc) as rn
from cte where s<=1000
)
select person_name from ste where rn=1;