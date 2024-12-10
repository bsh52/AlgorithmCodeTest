-- 코드를 작성해주세요
SELECT 
    E.id,
    CASE 
        WHEN E.size_of_colony <= 100
        THEN "LOW"
        WHEN E.size_of_colony > 100 && E.size_of_colony <= 1000
        THEN "MEDIUM"
        WHEN E.size_of_colony > 1000
        THEN "HIGH"
    END AS SIZE
FROM ecoli_data AS E
ORDER BY E.id;