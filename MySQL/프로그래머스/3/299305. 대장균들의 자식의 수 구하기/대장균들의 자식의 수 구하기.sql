-- 코드를 작성해주세요
SELECT E.id,
IFNULL(COUNT(E2.parent_id), 0) AS `CHILD_COUNT`
FROM ecoli_data AS E
LEFT JOIN (
    SELECT parent_id
    FROM ecoli_data
) AS E2
ON E.id = E2.parent_id
GROUP BY E.id
ORDER BY E.id;