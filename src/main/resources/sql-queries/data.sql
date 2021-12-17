-- Sample data for categories
INSERT INTO categories( id, name, breakdown, id_super_category)  VALUES (	1	,'Moda',	1	,	null	);
INSERT INTO categories( id, name, breakdown, id_super_category)  VALUES (	2	,'Elektronik',	1	,	null	);
INSERT INTO categories( id, name, breakdown, id_super_category)  VALUES (	3	,'Ev & Yaşam',	1	,	null	);
INSERT INTO categories( id, name, breakdown, id_super_category)  VALUES (	4	,'Elbise',	2	,	1	);
INSERT INTO categories( id, name, breakdown, id_super_category)  VALUES (	5	,'Gömlek',	2	,	1	);
INSERT INTO categories( id, name, breakdown, id_super_category)  VALUES (	6	,'Bilgisayar',	2	,	2	);
INSERT INTO categories( id, name, breakdown, id_super_category)  VALUES (	7	,'Dizüstü Bilgisayar',	3	,	6	);
INSERT INTO categories( id, name, breakdown, id_super_category)  VALUES (	8	,'Mobilya',	2	,	3	);
INSERT INTO categories( id, name, breakdown, id_super_category)  VALUES (	9	,'Sehpa',	3	,	8	);


-- Sample data for products
INSERT INTO products( id, name , price, creation_date, id_category) VALUES (	1	,'Mavi Elbise',	200	, now(), 	4);
INSERT INTO products( id, name , price, creation_date, id_category) VALUES (	2	,'Kırmızı Elbise',	300	, now(), 	4);
INSERT INTO products( id, name , price, creation_date, id_category) VALUES (	3	,'Mavi Gömlek',	500	, now(), 	5);
INSERT INTO products( id, name , price, creation_date, id_category) VALUES (	4	,'Sarı Gömlek',	450	, now(), 	5);
INSERT INTO products( id, name , price, creation_date, id_category) VALUES (	5	,'HP ',	15000	, now(), 	7);
INSERT INTO products( id, name , price, creation_date, id_category) VALUES (	6	,'MSI',	20000	, now(), 	7);
INSERT INTO products( id, name , price, creation_date, id_category) VALUES (	7	,'Orta Sehpa',	600	, now(), 	9);


-- Sample data for users
INSERT INTO users( id, username, name , surname, email, phone_number) VALUES (	1	,'tcoskun' ,'Tarık'	,'COŞKUN'	,'tarikcoskun@hotmail.com.tr'	,'05548960682');
INSERT INTO users( id, username, name , surname, email, phone_number) VALUES (	2	,'akeles' ,'Ali'		,'KELEŞ'	,'alikeles@hotmail.com'			,'05356987416');
INSERT INTO users( id, username, name , surname, email, phone_number) VALUES (	3	,'bcelik' ,'Beyza'	,'ÇELİK'	,'beyzac@outlook.com.tr'		,'05421548937');
INSERT INTO users( id, username, name , surname, email, phone_number) VALUES (	4	,'ekatip' ,'Elif'		,'KATİP'	,'katipelif@gmail.com'			,'05563178965');
INSERT INTO users( id, username, name , surname, email, phone_number) VALUES (	5	,'aaslan' ,'Ahmet'	,'ASLAN'	,'aaslan@yahoo.com'				,'05555556987');
INSERT INTO users( id, username, name , surname, email, phone_number) VALUES (	6	,'kkiraz' ,'Kerem'	,'KİRAZ'	,'keremkiraz@hotmail.com.tr'	,'05486587215');
INSERT INTO users( id, username, name , surname, email, phone_number) VALUES (	7	,'sakyol' ,'Seray'	,'AKYOL'	,'serayyyakyol@hotmail.com'		,'05386649987');


-- Sample data for product_comments
INSERT INTO product_comments(id, creation_date, text, id_product, id_user)
VALUES (1, now(),
        'The European languages are members of the same family. Their separate existence is a myth. For scien',
        2, 3);

INSERT INTO product_comments(id, creation_date, text, id_product, id_user)
VALUES (2, now(),
        'Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large.',
        2, 7);

INSERT INTO product_comments(id, creation_date, text, id_product, id_user)
VALUES (3, now(),
        'A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was.',
        6, 1);

INSERT INTO product_comments(id, creation_date, text, id_product, id_user)
VALUES (4, now(),
        'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu',
        7, 7);

INSERT INTO product_comments(id, creation_date, text, id_product, id_user)
VALUES (5, now(),
        'The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz. Brick quiz whangs jumpy veldt fox. Bright vixens jump; dozy fowl quack. Qu',
        5, 6);

INSERT INTO product_comments(id, creation_date, text, id_product, id_user)
VALUES (6, now(),
        'But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids',
        6, 3);