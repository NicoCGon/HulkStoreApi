INSERT INTO User (user_id,username,password,enabled) VALUES(1,'nicolasgonzalez995@hotmail.com','$2a$05$5GT0Se0iqAdPj5ylSmbPbeNkNDKI.Zudn6hqTqTjS/WjM.4uiukCC',1);
INSERT INTO User (user_id,username,password,enabled) VALUES(2,'diegoRainer@hotmail.com','$2a$05$OdbUvdUX4zayXsD6ywowDeaugAt0FZMkc0pa5jISvNyzHAZdrPRXe',1);
INSERT INTO User (user_id,username,password,enabled) VALUES(3,'sebastianBignolo@hotmail.com','$2a$05$OdbUvdUX4zayXsD6ywowDeaugAt0FZMkc0pa5jISvNyzHAZdrPRXe',1);

INSERT INTO Authority (authority_id,authority) VALUES (1, 'ROLE_ADMIN');
INSERT INTO Authority (authority_id,authority) VALUES (2, 'ROLE_USER');

INSERT INTO user_authority (user_id, authority_id) VALUES (1,1);
INSERT INTO user_authority (user_id, authority_id) VALUES (1,2);
INSERT INTO user_authority (user_id, authority_id) VALUES (2,2);