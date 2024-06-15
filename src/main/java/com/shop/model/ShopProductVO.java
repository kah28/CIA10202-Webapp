package com.shop.model;
import java.sql.Timestamp;

public class ShopProductVO implements java.io.Serializable{
	private Integer prodNo;
	private Integer prodTypeNo;
	private String prodName;
	private String prodInfo;
	private Integer prodPrice;
	private Integer prodStatus;
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
