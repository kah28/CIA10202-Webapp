CREATE DATABASE IF NOT EXISTS CIA102G2DB;

USE CIA102G2DB;

DROP TABLE IF EXISTS knowledge;

CREATE TABLE knowledge (
		
	know_no INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	know_title VARCHAR(30) NOT NULL,
	know_content LONGTEXT NOT NULL,
	know_publishtime DATETIME NOT NULL
	
) AUTO_INCREMENT = 1;

INSERT INTO knowledge (know_title, know_content, know_publishtime) VALUES ('新手登山入門等級介紹', '臺灣地形特殊高山雄偉峻嶺，而素有「摩爾摩沙」之美稱。身為全球高山密度最高的國家，登山活動當然也是相當活躍，其中又以「五嶽三尖一奇」最具代表性，也是眾多新手登山入門的目標之一。', STR_TO_DATE('2024-05-01 10:02:00', '%Y-%m-%d %H:%i:%s'));

INSERT INTO knowledge (know_title, know_content, know_publishtime) VALUES ('新手登山注意事項有哪些？爬山技巧看這邊！', '對於新手入門登山者來說，想要體會從高山俯瞰這美麗的世界，卻不懂得有哪些事項需要注意？由於登山當天突發狀況不可知，故在行前就必須將裝備帶齊並充分了解其3大注意事項：
																	1. 穿著衣物 適當好走
																	由於山上日夜溫差大，且較易有蚊蟲叮咬，故在衣著上也是需要特別注意。建議內穿一件吸濕排汗衫，並搭配運動長褲、帽子與耐走好穿的登山鞋，隨身再攜帶一件輕便的登山外套就可以讓你輕鬆登山舒適健走。
																	2. 裝備齊全 說走就走
																	在登山的路途上，總不可能與在平地一樣隨時隨地都有商店可補充補給。故在行前就必須先將所有登山裝備準備齊全，這樣才不會讓你爬山到半途才發現少了裝備無法攻頂喔！
																	3. 食物備妥 補充體力', STR_TO_DATE('2024-05-28 09:45:00', '%Y-%m-%d %H:%i:%s') );
INSERT INTO knowledge (know_title, know_content, know_publishtime) VALUES ('新手入門登山裝備清單推薦', '對新手登山者來說，在爬山的路程中不會有商店的出現，也不會有任何可補給的項目。若沒有將登山物品一次帶齊，那將會使你的入門登山之旅更為不便。故建議以下裝備清單務必逐一勾選，才不會造成臨時狀況無法應變喔！' , STR_TO_DATE('2024-06-03 10:21:00', '%Y-%m-%d %H:%i:%s'));
INSERT INTO knowledge (know_title, know_content, know_publishtime) VALUES ('新手登山入門常見QA', '新手登山入門常見QA
																					Q1. 建議新手先從哪座山開始爬起？
																					Q2. 如何申請入山？
																					Q3. 新手登山要如何穿？去哪過夜？', STR_TO_DATE('2024-05-01 10:02:00', '%Y-%m-%d %H:%i:%s'));

-- 以下測試變量用:
-- show variables like '%auto_inc%';
-- show session variables like '%auto_inc%';  -- //session變量
-- show global variables  like '%auto_inc%';  -- //global變量

-- 以下測試環境的 版本、SSL、 字元編碼用:
-- select version();
-- show variables like '%ssl%';  [ 或執行 mysql> \s ]
-- show variables like '%character%';