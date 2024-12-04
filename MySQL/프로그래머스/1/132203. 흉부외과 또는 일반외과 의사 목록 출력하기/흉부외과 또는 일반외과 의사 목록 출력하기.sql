-- 코드를 입력하세요
SELECT 
dr_name,
dr_id,
MCDP_CD,
DATE_FORMAT(hire_ymd, '%Y-%m-%d') as HIRE_YMD
from doctor
where MCDP_CD = 'cs'
or MCDP_CD = 'gs'
order by hire_ymd desc, dr_name;