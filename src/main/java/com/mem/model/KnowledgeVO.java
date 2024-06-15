package com.mem.model;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "knowledge")
public class KnowledgeVO implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="know_title", updatable = false, insertable = false)
	private Integer knowNo;
	
	@Column(name ="know_content")
	private String knowTitle;
	
	@Column(name ="knowcontent")
	private String knowContent;
	
	@Column(name ="know_publishime")
	private Timestamp knowPublishTime;
	
	
	public Integer getKnowNo() {
		return knowNo;
	}
	public void setKnowNo(Integer knowNo) {
		this.knowNo = knowNo;
	}
	public String getKnowTitle() {
		return knowTitle;
	}
	public void setKnowTitle(String knowTitle) {
		this.knowTitle = knowTitle;
	}
	public String getKnowContent() {
		return knowContent;
	}
	public void setKnowContent(String knowContent) {
		this.knowContent = knowContent;
	}
	public Timestamp getKnowPublishTime() {
		return knowPublishTime;
	}
	public void setKnowPublishTime(Timestamp knowPublishTime) {
		this.knowPublishTime = knowPublishTime;
	}


}
