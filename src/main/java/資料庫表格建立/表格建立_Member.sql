CREATE DATABASE IF NOT EXISTS CIA102G2DB;

USE CIA102G2DB;

CREATE TABLE member (
	mem_no     		INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	mem_name     	VARCHAR(10) NOT NULL,
	mem_sex     	CHAR(1) NOT NULL,
	mem_phone  		VARCHAR(10) NOT NULL,
	mem_email    	VARCHAR(40) NOT NULL,
	mem_uid      	VARCHAR(10) NOT NULL,
    mem_birthday	DATE NOT NULL,
    mem_account		VARCHAR(20) NOT NULL,
    mem_password	VARCHAR(20) NOT NULL,
    mem_img			LONGBLOB,
    mem_status		TINYINT NOT NULL DEFAULT 1
    ) AUTO_INCREMENT = 1001;

INSERT INTO member (mem_name, mem_sex, mem_phone, mem_email, mem_uid, mem_birthday, mem_account, mem_password, mem_img)
VALUES 	('楊翰祁', 'm', '0987654321', 'leo8152257@gmail.com', 'H123456789', STR_TO_DATE('1992-05-22','%Y-%m-%d'), 'leo8152257', 'password', null),
		('蔡依林', 'f', '0912345678', 'tsaiyilin@gmail.com', 'H224568954', STR_TO_DATE('1980-09-15','%Y-%m-%d'), 'goodhuang', 'password123', null),
		('伍佰', 'm', '0934567892', 'fivehundred@gmail.com', 'H124568954', STR_TO_DATE('1968-01-14','%Y-%m-%d'), 'greatlu', 'password456', null);
		
-- 以下測試變量用:
-- show variables like '%auto_inc%';
-- show session variables like '%auto_inc%';  -- //session變量
-- show global variables  like '%auto_inc%';  -- //global變量

-- 以下測試環境的 版本、SSL、 字元編碼用:
-- select version();
-- show variables like '%ssl%';  [ 或執行 mysql> \s ]
-- show variables like '%character%';