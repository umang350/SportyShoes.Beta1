

INSERT INTO `admin` (`id`,`username`,`password`,`role`,`enabled`)
VALUES (1,'umang',
'$2a$10$32QqsXPP4WRBORIu32b2R.jWV8tLBvB3rL6WnDCPHYnKAD9FKCaUy',
'ROLE_USER', 1);
 
INSERT INTO `admin` (`id`,`username`,`password`,`role`,`enabled`)
VALUES (2,'admin',
'$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy',
'ROLE_ADMIN', 1);

INSERT INTO `product` (`pid`,`product_name`,`category`,`stock`,`price`)
VALUES (1001,'Reebok Shoes','Sports',15,4000);
INSERT INTO `product` (`pid`,`product_name`,`category`,`stock`,`price`)
VALUES (1002,'Adidas Shoes','Sports',35,8000);
INSERT INTO `product` (`pid`,`product_name`,`category`,`stock`,`price`)
VALUES (1003,'Nike Shoes','Sports',18,6000);
INSERT INTO `product` (`pid`,`product_name`,`category`,`stock`,`price`)
VALUES (1004,'H&M Footwear','Party',28,9000);
INSERT INTO `product` (`pid`,`product_name`,`category`,`stock`,`price`)
VALUES (1005,'Gucci gang Foots','Party',8,26000);

INSERT INTO `user` (`uid`,`user_name`,`user_email`,`user_password`,`address`,`mobile`)
VALUES (2001,'tony kakkar','tony@kakkar.com','tony123','mumbai','9899261601');
INSERT INTO `user` (`uid`,`user_name`,`user_email`,`user_password`,`address`,`mobile`)
VALUES (2002,'neha goel','neha@goel.com','neha_goel','delhi','8899231601');
INSERT INTO `user` (`uid`,`user_name`,`user_email`,`user_password`,`address`,`mobile`)
VALUES (2003,'jimmy shergil','jimmy@gill.com','jimbo','pune','9783761601');
INSERT INTO `user` (`uid`,`user_name`,`user_email`,`user_password`,`address`,`mobile`)
VALUES (2004,'ab bachchan','ab@bachchan.com','abbab','south bombay','7799261601');

INSERT INTO `purchase` (`purchase_id`,`product_id`,`category`,`amount`,`quantity`,`purchase_date`)
VALUES (3001,1001,'Sports',4000,1,'2020-10-02');
INSERT INTO `purchase` (`purchase_id`,`product_id`,`category`,`amount`,`quantity`,`purchase_date`)
VALUES (3002,1002,'Sports',6000,2,'2020-10-01');
INSERT INTO `purchase` (`purchase_id`,`product_id`,`category`,`amount`,`quantity`,`purchase_date`)
VALUES (3003,1005,'Party',33000,3,'2020-09-15');
INSERT INTO `purchase` (`purchase_id`,`product_id`,`category`,`amount`,`quantity`,`purchase_date`)
VALUES (3004,1004,'Party',88000,12,'2020-07-11');

