package com.shop.model;

import java.util.List;


public class ShopProductPicService {

	private ShopProductPicDAO_interface dao;
	
	public ShopProductPicService() {
		dao = new ShopProductPicDAO();
	}
	
	
	public ShopProductPicVO addProductPic(Integer prodNo, byte[] prodPic) {
		
		ShopProductPicVO shopProductPicVO = new ShopProductPicVO();
		
		shopProductPicVO.setProdNo(prodNo);
		shopProductPicVO.setProdPic(prodPic);
		dao.insert(shopProductPicVO);
		
		return shopProductPicVO;
	}
	

	public ShopProductPicVO updateProductPic(Integer prodPicNo, Integer prodNo, byte[] prodPic) {
			
		ShopProductPicVO shopProductPicVO = new ShopProductPicVO();
		
		shopProductPicVO.setProdPicNo(prodPicNo);
		shopProductPicVO.setProdNo(prodNo);
		shopProductPicVO.setProdPic(prodPic);
		dao.update(shopProductPicVO);
		
		return shopProductPicVO;
		}
	
	public void deleteProductPic(Integer prodPicNo) {
		dao.delete(prodPicNo);
	}
	
	public ShopProductPicVO getOneProdPicNo(Integer prodPicNo) {
		return dao.findByPrimaryKey(prodPicNo);
	}
	
	public List<ShopProductPicVO> getAll() {
		return dao.getAll();
	}
	
	
	
}
