-- 코드를 입력하세요
SELECT 
    book_id as BOOK_ID,
    date_format(published_date, '%Y-%m-%d') as PUBLISHED_DATE
FROM BOOK
WHERE category = '인문'
AND date_format(published_date,'%Y') = '2021'
order by published_date;