with cte as
(
    select 
*, row_number() over (partition by customer_number order by order_number) as rn
from Orders
)
select customer_number from cte order by rn desc limit 1