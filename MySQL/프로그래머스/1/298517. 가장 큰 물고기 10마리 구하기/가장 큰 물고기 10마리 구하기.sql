-- 코드를 작성해주세요
SELECT 
    id as `ID`,
    length as `LENGTH`
FROM fish_info
WHERE length > 10
ORDER BY length DESC, id
LIMIT 10;
