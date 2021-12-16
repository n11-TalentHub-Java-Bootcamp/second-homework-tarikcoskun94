Select *
FROM PRODUCTS
LEFT OUTER JOIN PRODUCT_COMMENTS
ON PRODUCTS.id=PRODUCT_COMMENTS.id_product;

-------------------------------------------------------------------------------------------

Select p.id, count(pc.id) as comment_count
FROM PRODUCTS as p
LEFT OUTER JOIN PRODUCT_COMMENTS as pc
ON p.id=pc.id_product
GROUP BY p.id;

-------------------------------------------------------------------------------------------

Select p.id,
    CASE
        WHEN count(pc.id)>0 THEN count(pc.id)
    END as comment_count
FROM PRODUCTS as p
LEFT OUTER JOIN PRODUCT_COMMENTS as pc
ON p.id=pc.id_product
GROUP BY p.id;

-------------------------------------------------------------------------------------------

Select p.id, p.name, p.price,
    CASE
        WHEN count(pc.id)>0 THEN count(pc.id)
    END as comment_count
FROM PRODUCTS as p
LEFT OUTER JOIN PRODUCT_COMMENTS as pc
ON p.id=pc.id_product
GROUP BY p.id;