-- 코드를 작성해주세요

select info.item_id, info.item_name
from item_info info
inner join item_tree tree
on tree.item_id = info.item_id
where tree.parent_item_id is null