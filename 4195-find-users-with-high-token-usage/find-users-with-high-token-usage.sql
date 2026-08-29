with cte as (
    select user_id,tokens,avg(tokens) over (partition by user_id order by user_id) as avrg,count(*) over (partition by user_id order by user_id) as prompt_count from prompts
)select distinct user_id,prompt_count,round(avrg,2) as 'avg_tokens' from cte where prompt_count>=3 and tokens>avrg order by avrg desc