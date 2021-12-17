select *
from product_comments as pc
join users as u
on pc.id_user = u.id
where u.id = 7