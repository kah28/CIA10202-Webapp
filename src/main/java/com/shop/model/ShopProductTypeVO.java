package com.shop.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shop_product_type")
public class ShopProductTypeVO implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="prod_type_no", updatable = false, insertable = false)
	private Integer prodTypeNo;
	
	@Column(name ="prod_type_name")
	private String prodTypeName;
	
	public Integer getProdTypeNo() {
		return prodTypeNo;
	}
	public void setProdTypeNo(Integer prodTypeNo) {
		this.prodTypeNo = prodTypeNo;
	}
	public String getProdTypeName() {
		return prodTypeName;
	}
	public void setProdTypeName(String prodTypeName) {
		this.prodTypeName = prodTypeName;
	}
	

}
