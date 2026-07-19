# Write your MySQL query statement below
SELECT score, rnk as `rank`
FROM (
    SELECT
        Score,
        DENSE_RANK() OVER (ORDER BY Score DESC) AS rnk
    FROM Scores
) AS t;