package com.shop.model;

import java.util.*;

public interface ShopProductPicDAO_interface {

	public void insert(ShopProductPicVO shopProductPicVO);
	public void update(ShopProductPicVO shopProductPicVO); //?
	public void delete(Integer prodPicNo);
	public ShopProductPicVO findByPrimaryKey(Integer prodPicNo);
	public List<ShopProductPicVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<ShopProductPicVO> getALL(Map<String, String[]> map);
	

}





