package com.shop.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shop_product_pic")
public class ShopProductPicVO implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="prod_pic_no", updatable = false, insertable = false)
	private Integer prodPicNo;
	
	@Column(name ="prod_no")
	private Integer prodNo;
	
	@Column(name ="prod_pic")
	private byte[] prodPic;
	
	public Integer getProdPicNo() {
		return prodPicNo;
	}
	public void setProdPicNo(Integer prodPicNo) {
		this.prodPicNo = prodPicNo;
	}
	public Integer getProdNo() {
		return prodNo;
	}
	public void setProdNo(Integer prodNo) {
		this.prodNo = prodNo;
	}
	public byte[] getProdPic() {
		return prodPic;
	}
	public void setProdPic(byte[] prodPic) {
		this.prodPic = prodPic;
	}
	

	

}
