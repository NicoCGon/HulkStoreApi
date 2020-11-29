INSERT INTO User (user_id,username,password,enabled) VALUES(1,'nicolasgonzalez995@hotmail.com','$2a$05$5GT0Se0iqAdPj5ylSmbPbeNkNDKI.Zudn6hqTqTjS/WjM.4uiukCC',1);
INSERT INTO User (user_id,username,password,enabled) VALUES(2,'diegoRainer@hotmail.com','$2a$05$OdbUvdUX4zayXsD6ywowDeaugAt0FZMkc0pa5jISvNyzHAZdrPRXe',1);
INSERT INTO User (user_id,username,password,enabled) VALUES(3,'sebastianBignolo@hotmail.com','$2a$05$OdbUvdUX4zayXsD6ywowDeaugAt0FZMkc0pa5jISvNyzHAZdrPRXe',1);

INSERT INTO Authority (authority_id,authority) VALUES (1, 'ROLE_ADMIN');
INSERT INTO Authority (authority_id,authority) VALUES (2, 'ROLE_USER');

INSERT INTO user_authority (user_id, authority_id) VALUES (1,1);
INSERT INTO user_authority (user_id, authority_id) VALUES (1,2);
INSERT INTO user_authority (user_id, authority_id) VALUES (2,2);

INSERT INTO Product (product_id,product_name,product_und,product_url, product_stock) VALUES(1154,'Buzo Marvel',1,'https://m.media-amazon.com/images/I/81aYUS9mfCL._AC_UL320_.jpg',50);
INSERT INTO Product (product_id,product_name,product_und,product_url, product_stock) VALUES(1155,'Camiseta Marvel',1,'https://i.pinimg.com/236x/94/91/b0/9491b09b1067ff4d89af4a176347e931--printed-hoodies-harajuku.jpg',70);
INSERT INTO Product (product_id,product_name,product_und,product_url, product_stock) VALUES(1156,'Camiseta Superman DC Comics',1,'https://images-na.ssl-images-amazon.com/images/I/91u7bA1AZGL._AC_UX342_.jpg',35);
INSERT INTO Product (product_id,product_name,product_und,product_url, product_stock) VALUES(1157,'Camiseta FLash DC Comics',1,'https://cdn.shopify.com/s/files/1/1021/9753/products/flash_tie_die_tee_800x.jpg?v=1517520678',41);

INSERT INTO Kardex (kardex_id,kardex_counter) VALUES(1,196);
