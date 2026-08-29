with cte as (
    select t.id,t.client_id,t.driver_id,t.status,t.request_at from Trips t
    left join users u_client
    on t.client_id=u_client.users_id
    left join users u_driver
    on t.driver_id=u_driver.users_id
    where u_client.banned!='Yes' and u_driver.banned!='Yes' 
    and u_client.role='client' and u_driver.role='driver'
    order by id
),cte2 as (
    select *,count(*) over (partition by request_at order by request_at) as ct from cte
),cte3 as (
    select request_at from cte where status='cancelled_by_client' or status='cancelled_by_driver'
),cte4 as (
    select request_at,count(*) over(partition by request_at order by request_at) as cnt from cte3 
),cte5 as(
    select distinct c.request_at,c.ct,t.cnt from cte2 c
    left join 
    cte4 t
    on c.request_at=t.request_at
)SELECT 
    request_at as 'Day',
    ROUND(COALESCE(cnt, 0) / ct, 2) AS 'Cancellation Rate'
FROM cte5 where request_at>='2013-10-01' and request_at<='2013-10-03';
