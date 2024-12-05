-- 코드를 입력하세요
SELECT
    B.title,
    B.board_id,
    R.reply_id,
    R.writer_id,
    R.contents,
    date_format(R.created_date, '%Y-%m-%d') as CREATED_DATE
from 
    USED_GOODS_BOARD as B
    inner join USED_GOODS_REPLY as R
    on B.board_id = R.board_id
where 
    date_format(B.created_date, '%Y-%m') = '2022-10'
order by 
    R.created_date asc, B.title asc;