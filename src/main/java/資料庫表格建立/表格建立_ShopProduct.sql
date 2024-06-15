CREATE DATABASE IF NOT EXISTS CIA102G2DB;

USE CIA102G2DB;

DROP TABLE IF EXISTS shop_product;

CREATE TABLE shop_product (
		
	prod_no INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	prod_type_no INT NOT NULL,
	prod_name VARCHAR(100) NOT NULL,
	prod_info LONGTEXT NOT NULL,
	prod_price INT NOT NULL,
	prod_status TINYINT NOT NULL DEFAULT 0,
	prod_begdate DATETIME NOT NULL,
	prod_enddate DATETIME,
	
	CONSTRAINT shopproduct_prodtypeno_FK FOREIGN KEY (prod_type_no) REFERENCES shop_product_type (prod_type_no)
	
) AUTO_INCREMENT = 1;

INSERT INTO shop_product (prod_type_no, prod_name, prod_info, prod_price, prod_begdate) 
			VALUES (1, 'A.T.P. 20L 多功能日用旅行背包 經典黑', 
					'兩側有可調節式壓縮帶，易於收納和壓縮。
					可調整伸縮胸扣
					背帶可以附掛額外的裝備或設備
					透氣網布肩帶
					側邊彈性水瓶口袋
					內部軟墊口袋可安全固定太陽眼鏡
					多個收納口袋及安全口袋，可隨時放置鑰匙文具等
					內含可拆卸式內襯筆記型電腦帶
					可掛行李箱拉桿
					設計吸管出水口，可放置水袋
					使用CamelBak金量級標章環保材質
					背包主體及底部-210D CORDURA® re/cor™ N66環保再生尼龍
					背包內襯使用210D CORDURA re/cor™ N6環保再生尼龍
					背帶使用聚酯纖維
					總容量：20公升
					背包重量 : 1.16KG
					適合旅行/日用/健行 使用', 
					5900, STR_TO_DATE('2024-04-29 00:00:00', '%Y-%m-%d %H:%i:%s'));

INSERT INTO shop_product (prod_type_no, prod_name, prod_info, prod_price, prod_begdate) 
			VALUES (1, 'MONTURA Ararat 35L 多功能背包(附防水背包套) 深藍', 
					'尼龍 Cordura® 材質製成，強韌耐用。
					舒適EVA泡棉背板，能有效分散背部壓力。
					腰帶上有兩個拉鍊口袋。
					兩邊網眼側袋。
					帶拉鍊的頂袋可快速拿取物品。
					可容納水袋。
					大開口拉鍊前袋便於快速拿取物品。
					側邊織袋可固定登山杖等物品。
					附防水背包套。
					重量約1440g。', 
					7600, STR_TO_DATE('2024-04-29 00:00:00', '%Y-%m-%d %H:%i:%s'));
					
INSERT INTO shop_product (prod_type_no, prod_name, prod_info, prod_price, prod_begdate) 
			VALUES (1, 'Norix 48L 登山背包 深綠', 
					'經典中型登山背包，採用舒適但更輕量的可調式背負系統，便利的前方環繞式拉鍊開口、內部可容納水袋，想要一個應有盡有的輕量登山背包嗎?就是Norix 48了!
					主袋與底袋間有拉鍊隔層
					臀帶上有織帶可微調背包的重心
					胸帶可調整高度
					增強透氣性的泡綿臀帶
					可調式側邊壓縮帶
					前、後提把
					頂袋可調整高度、頂部附有裝備繩環
					頂袋內有物品掛環
					附防水背包套
					可容納水袋系統
					前方環繞式拉鍊開口
					底部壓縮帶
					彈性側袋
					登山杖與冰斧固定環
					裝備繩環附於背包前方
					大型拉鍊前袋
					重量：約1.75 公斤
					容量：48 公升
					尺寸：70x29x20 公分', 
					6000, STR_TO_DATE('2024-05-01 00:00:00', '%Y-%m-%d %H:%i:%s'));
			
INSERT INTO shop_product (prod_type_no, prod_name, prod_info, prod_price, prod_begdate) 
			VALUES (2, 'LOWA RENEGADE 男 中筒多功能健行鞋 RENEGADE GTX MID 深灰', 
					'LOWA 男 中筒多功能健行鞋 RENEGADE GTX MID
					由牛巴革材質所構成，透過縫合讓鞋款更貼合腳型，加強腳部包覆力。
					GORE-TEX® footwear防水膜使用，足以應付戶外環境的多變氣候，徹底阻擋水氣滲入，保持腳部乾爽不失溫，提供絕佳舒適感。
					使用Vibram® EVO黃金大底，加強抓地力，給予行走間最佳的抓地力與穩定性，並提供了一定的緩衝，適合於多種環境中使用，長時間行走也不感覺疲憊。
					LOWA專利 MONOWRAP®科技應用，TPU支撐片與PU射出中底提供更多的支撐性，降低行走間的負擔。
					商品重量：約880公克 (UK5/雙)', 
					8200, STR_TO_DATE('2024-04-29 00:00:00', '%Y-%m-%d %H:%i:%s'));
			
INSERT INTO shop_product (prod_type_no, prod_name, prod_info, prod_price, prod_begdate) 
			VALUES (2, 'LOWA 女 中筒多功能健行鞋 寬楦 RENEGADE GTX MID Ws WIDE', 'LOWA 女 中筒多功能健行鞋 寬楦 RENEGADE GTX MID WIDE
					由牛巴革和織布兩種材質所構成，透過縫合讓鞋款更貼合腳型，加強腳部包覆力。
					GORE-TEX® footwear防水膜，足以應付戶外環境的多變氣候，阻擋水氣滲入，並提供良好透氣表現，保持腳部乾爽不失溫，提供絕佳舒適感。
					使用Vibram® EVO黃金大底，加強抓地力，給予行走間最佳的抓地力與穩定性，適合於多種環境中使用，長時間行走也不感覺疲憊。
					LOWA專利 MONOWRAP® 科技應用，TPU支撐片與PU雙重射出中底提供更多的支撐性與緩衝感，降低行走時的負擔。
					寬楦頭的設計更適合東方人的腳型。
					商品重量：約475公克(單腳)', 
					8000, STR_TO_DATE('2024-04-29 00:00:00', '%Y-%m-%d %H:%i:%s'));
			
INSERT INTO shop_product (prod_type_no, prod_name, prod_info, prod_price, prod_begdate) 
			VALUES (3, 'FIZAN 超輕三節式登山杖 Pivot綠 2入組', 
					'FIZAN 超輕三節式健行登山杖2入特惠組
					長度：約 59-132 公分
					重量：單支約 158g
					材質：7001 高強度鋁合金
					專利「FLEXY」閉鎖系統，可承受垂直100公斤的力量
					腕帶：聚酯纖維，輕量、柔軟且快乾
					握把：依人體工學設計的EVA泡綿
					杖尖：鎢鋼材質
					杖尖保護套、50mm擋泥板、35mm擋泥板
					義大利製造原裝進口', 
					3500, STR_TO_DATE('2024-05-05 00:00:00', '%Y-%m-%d %H:%i:%s'));
			
-- 以下測試變量用:
-- show variables like '%auto_inc%';
-- show session variables like '%auto_inc%';  -- //session變量
-- show global variables  like '%auto_inc%';  -- //global變量

-- 以下測試環境的 版本、SSL、 字元編碼用:
-- select version();
-- show variables like '%ssl%';  [ 或執行 mysql> \s ]
-- show variables like '%character%';