-- 코드를 입력하세요
SELECT
    member_id,
    member_name,
    gender,
    DATE_FORMAT(date_of_birth, "%Y-%m-%d")
FROM MEMBER_PROFILE
where gender = "W"
AND DATE_FORMAT(date_of_birth, "%m") = "03"
AND TLNO is not null
ORDER BY member_id;