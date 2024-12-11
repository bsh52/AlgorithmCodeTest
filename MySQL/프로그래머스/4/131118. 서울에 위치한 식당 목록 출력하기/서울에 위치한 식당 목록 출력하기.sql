-- 코드를 입력하세요
SELECT I.rest_id,
I.rest_name,
I.food_type,
I.favorites,
I.address,
ROUND(AVG(R.review_score), 2) AS `리뷰평균점수`
FROM rest_info AS I
INNER JOIN rest_review AS R
ON I.rest_id = R.rest_id
WHERE I.address LIKE "서울%"
GROUP BY I.rest_id
ORDER BY `리뷰평균점수` DESC, I.favorites DESC;