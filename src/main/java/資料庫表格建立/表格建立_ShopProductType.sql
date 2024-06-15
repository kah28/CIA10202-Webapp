
CREATE DATABASE IF NOT EXISTS CIA102G2DB;

USE CIA102G2DB;

DROP TABLE IF EXISTS shop_product_type;

CREATE TABLE shop_product_type (
	
	prod_type_no INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	prod_type_name VARCHAR(20) NOT NULL
	
	
) AUTO_INCREMENT = 1;

INSERT INTO shop_product_type (prod_type_name) VALUES ('包袋');
INSERT INTO shop_product_type (prod_type_name) VALUES ('鞋類');
INSERT INTO shop_product_type (prod_type_name) VALUES ('裝備配件');
INSERT INTO shop_product_type (prod_type_name) VALUES ('服飾');
-- 以下測試變量用:
-- show variables like '%auto_inc%';
-- show session variables like '%auto_inc%';  -- //session變量
-- show global variables  like '%auto_inc%';  -- //global變量

-- 以下測試環境的 版本、SSL、 字元編碼用:
-- select version();
-- show variables like '%ssl%';  [ 或執行 mysql> \s ]
-- show variables like '%character%';