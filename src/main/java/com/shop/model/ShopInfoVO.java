package com.shop.model;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shop_info")
public class ShopInfoVO implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="info_no", updatable = false, insertable = false)
	private Integer infoNo;
	
	@Column(name ="info_date")
	private Timestamp infoDate;
	
	@Column(name ="info_head")
	private String infoHead;
	
	@Column(name ="info_content")
	private String infoContent;
	
	@Column(name ="info_status")
	private Integer infoStatus;
	
	public Integer getInfoNo() {
		return infoNo;
	}
	public void setInfoNo(Integer infoNo) {
		this.infoNo = infoNo;
	}
	public Timestamp getInfoDate() {
		return infoDate;
	}
	public void setInfoDate(Timestamp infoDate) {
		this.infoDate = infoDate;
	}
	public String getInfoHead() {
		return infoHead;
	}
	public void setInfoHead(String infoHead) {
		this.infoHead = infoHead;
	}
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	public Integer getInfoStatus() {
		return infoStatus;
	}
	public void setInfoStatus(Integer infoStatus) {
		this.infoStatus = infoStatus;
	}
	
	
	
	

}
