CREATE DATABASE IF NOT EXISTS CIA102G2DB;

USE CIA102G2DB;

DROP TABLE IF EXISTS shop_product_pic;

CREATE TABLE shop_product_pic (
	
	prod_pic_no	INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	prod_no	INT NOT NULL,
	prod_pic LONGBLOB
	
	CONSTRAINT shopproductpic_prodno_FK FOREIGN KEY (prod_no) REFERENCES shop_product (prod_no)
	
) AUTO_INCREMENT = 1;

INSERT INTO shop_product_pic (prod_no) VALUES (1);
INSERT INTO shop_product_pic (prod_no) VALUES (2);
INSERT INTO shop_product_pic (prod_no) VALUES (3);


-- 以下測試變量用:
-- show variables like '%auto_inc%';
-- show session variables like '%auto_inc%';  -- //session變量
-- show global variables  like '%auto_inc%';  -- //global變量

-- 以下測試環境的 版本、SSL、 字元編碼用:
-- select version();
-- show variables like '%ssl%';  [ 或執行 mysql> \s ]
-- show variables like '%character%';