-- 코드를 입력하세요
(SELECT 
    DATE_FORMAT(N.sales_date, "%Y-%m-%d") AS `SALES_DATE`,
    N.product_id,
    N.user_id,
    N.sales_amount
FROM online_sale AS N
WHERE SALES_DATE LIKE "2022-03%")
UNION ALL
(SELECT 
    DATE_FORMAT(F.sales_date, "%Y-%m-%d") AS `SALES_DATE`,
    F.product_id,
    null AS `USER_ID`,
    F.sales_amount
FROM offline_sale AS F
WHERE SALES_DATE LIKE "2022-03%")
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID;