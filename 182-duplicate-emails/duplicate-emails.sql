with cte as (
    select 
    *, 
    row_number() over (partition by email order by email) as rn
    from Person
)
select email as Email from cte where rn=2;
