package com.shop.model;

import java.sql.Timestamp;
import java.util.List;


public class ShopProductService {

	private ShopProductDAO_interface dao;
	
	public ShopProductService() {
		dao = new ShopProductDAO();
	}
	
	public ShopProductVO addProduct(Integer prodTypeNo, String prodName, String prodInfo, Integer prodPrice, Integer prodStatus, Timestamp prodDate) {
		
		ShopProductVO shopProductVO = new ShopProductVO();
		
		shopProductVO.setProdTypeNo(prodTypeNo);
		shopProductVO.setProdName(prodName);
		shopProductVO.setProdInfo(prodInfo);
		shopProductVO.setProdPrice(prodPrice);
		shopProductVO.setProdStatus(prodStatus);
		shopProductVO.setProdDate(prodDate);
		dao.insert(shopProductVO);
		
		return shopProductVO;
	}
	

	public ShopProductVO updateProduct(Integer prodTypeNo, String prodName, String prodInfo, Integer prodPrice, Integer prodStatus, Timestamp prodDate, Integer prodNo) {
			
		ShopProductVO shopProductVO = new ShopProductVO();
		
		shopProductVO.setProdTypeNo(prodTypeNo);
		shopProductVO.setProdName(prodName);
		shopProductVO.setProdInfo(prodInfo);
		shopProductVO.setProdPrice(prodPrice);
		shopProductVO.setProdStatus(prodStatus);
		shopProductVO.setProdDate(prodDate);
		shopProductVO.setProdNo(prodNo);
		
		dao.update(shopProductVO);
		
		return shopProductVO;
		}
	
	public void deleteProduct(Integer prodNo) {
		dao.delete(prodNo);
	}
	
	public ShopProductVO getOneProdNo(Integer prodNo) {
		return dao.findByPrimaryKey(prodNo);
	}
	
	public List<ShopProductVO> getAll() {
		return dao.getAll();
	}
	
	
	
}
