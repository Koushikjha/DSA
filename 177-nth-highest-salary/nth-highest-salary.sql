CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE result INT default null;
    WITH ranked AS (
    SELECT salary,
    dense_rank() over(order by salary desc) as rc,
    ROW_NUMBER() OVER (partition by salary ORDER BY salary DESC) AS rn
    FROM Employee
    )
    SELECT salary INTO result FROM ranked WHERE rn = 1 and rc=n;
    
    return result;
END