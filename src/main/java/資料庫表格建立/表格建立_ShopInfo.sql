CREATE DATABASE IF NOT EXISTS CIA102G2DB;

USE CIA102G2DB;

DROP TABLE IF EXISTS shop_info;

CREATE TABLE shop_info (
	
	info_no INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	info_date DATETIME NOT NULL,
	info_head VARCHAR(200) NOT NULL,
	info_content LONGTEXT NOT NULL,
	info_status TINYINT NOT NULL DEFAULT 0

	
) AUTO_INCREMENT = 1;

INSERT INTO shop_info (info_date, info_head, info_content) VALUES (STR_TO_DATE('2024-05-01 09:00:00', '%Y-%m-%d %H:%i:%s'), 'TopSeeker踏徙客商城新開幕優惠中', '慶祝商城新開幕，自即日起至2024-05-19，全館滿千89折');
INSERT INTO shop_info (info_date, info_head, info_content) VALUES (STR_TO_DATE('2024-06-01 10:11:00', '%Y-%m-%d %H:%i:%s'), '6月夏季優惠活動', '即日起至2024-06-16，全館滿三千7折，感謝您的支持');
INSERT INTO shop_info (info_date, info_head, info_content) VALUES (STR_TO_DATE('2024-07-02 10:11:00', '%Y-%m-%d %H:%i:%s'), '暑假出遊去特惠活動', '即日起至2024-06-21，全館滿兩千85折，歡迎選購您的出遊裝備');


-- 以下測試變量用:
-- show variables like '%auto_inc%';
-- show session variables like '%auto_inc%';  -- //session變量
-- show global variables  like '%auto_inc%';  -- //global變量

-- 以下測試環境的 版本、SSL、 字元編碼用:
-- select version();
-- show variables like '%ssl%';  [ 或執行 mysql> \s ]
-- show variables like '%character%';