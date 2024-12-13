-- 코드를 작성해주세요
SELECT I.item_id, I.item_name, I.rarity
FROM item_info AS I
INNER JOIN item_tree AS T
ON I.item_id = T.item_id
WHERE T.parent_item_id IN (
    SELECT item_id
    FROM item_info
    WHERE rarity = "RARE"
)
ORDER BY I.item_id DESC;