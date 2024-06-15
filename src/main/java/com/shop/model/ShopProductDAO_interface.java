package com.shop.model;

import java.util.*;

public interface ShopProductDAO_interface {

	public void insert(ShopProductVO shopProductVO);
	public void update(ShopProductVO shopProductVO);
	public void delete(Integer prodNo);
	public ShopProductVO findByPrimaryKey(Integer prodNo);
	public List<ShopProductVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<ShopProductVO> getALL(Map<String, String[]> map);
	

}





