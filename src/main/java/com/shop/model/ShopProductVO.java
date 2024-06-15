package com.shop.model;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "shop_product")
public class ShopProductVO implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="prod_no", updatable = false, insertable = false)
	private Integer prodNo;
	
	@Column(name ="prod_type_no")
	private Integer prodTypeNo;
	
	@Column(name ="prod_name")
	private String prodName;
	
	@Column(name ="prod_info")
	private String prodInfo;
	
	@Column(name ="prod_price")
	private Integer prodPrice;
	
	@Column(name ="prod_status")
	private Integer prodStatus;
	
	@Column(name ="prod_date")
	private Timestamp prodDate;
	
	public Integer getProdNo() {
		return prodNo;
	}
	public void setProdNo(Integer prodNo) {
		this.prodNo = prodNo;
	}
	public Integer getProdTypeNo() {
		return prodTypeNo;
	}
	public void setProdTypeNo(Integer prodTypeNo) {
		this.prodTypeNo = prodTypeNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdInfo() {
		return prodInfo;
	}
	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
	}
	public Integer getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(Integer prodPrice) {
		this.prodPrice = prodPrice;
	}
	public Integer getProdStatus() {
		return prodStatus;
	}
	public void setProdStatus(Integer prodStatus) {
		this.prodStatus = prodStatus;
	}
	public Timestamp getProdDate() {
		return prodDate;
	}
	public void setProdDate(Timestamp prodDate) {
		this.prodDate = prodDate;
	}

}
