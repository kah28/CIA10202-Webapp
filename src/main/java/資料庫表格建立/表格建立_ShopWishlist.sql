CREATE DATABASE IF NOT EXISTS CIA102G2DB;

USE CIA102G2DB;

DROP TABLE IF EXISTS shop_wishlist;

CREATE TABLE shop_wishlist (
	
	mem_no INT NOT NULL,
	prod_no INT NOT NULL,
	
	CONSTRAINT PK_shopwishlist_memno_prodno PRIMARY KEY(mem_no,prod_no)
		
) AUTO_INCREMENT = 1;

INSERT INTO shop_wishlist (mem_no, prod_no) VALUES (1001, 1);
INSERT INTO shop_wishlist (mem_no, prod_no) VALUES (1001, 3);
INSERT INTO shop_wishlist (mem_no, prod_no) VALUES (1001, 6);
INSERT INTO shop_wishlist (mem_no, prod_no) VALUES (1002, 5);
INSERT INTO shop_wishlist (mem_no, prod_no) VALUES (1002, 3);
INSERT INTO shop_wishlist (mem_no, prod_no) VALUES (1003, 4);
INSERT INTO shop_wishlist (mem_no, prod_no) VALUES (1003, 3);


-- 以下測試變量用:
-- show variables like '%auto_inc%';
-- show session variables like '%auto_inc%';  -- //session變量
-- show global variables  like '%auto_inc%';  -- //global變量

-- 以下測試環境的 版本、SSL、 字元編碼用:
-- select version();
-- show variables like '%ssl%';  [ 或執行 mysql> \s ]
-- show variables like '%character%';