-- 코드를 작성해주세요
SELECT id, email, first_name, last_name
FROM developers
WHERE skill_code & (
    SELECT sum(code)
    FROM skillcodes
    WHERE name in ("Python", "C#")
)
ORDER BY id;