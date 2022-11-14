package com.KrystalMovies.FoodMobsAPI.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "INVENTORYLIST")
public class InventoryList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "PRODUCTID")
	private String productid;
	@Column(name = "PRODUCTNAME")
	private String productname;
	@Column(name = "QUANTITY")
	private Integer quantity;
	@Column(name = "UNITTYPE")
	private String unittype;
	@Column(name = "PRICE")
	private Integer price;
	@Column(name = "SUBTOTAL")
	private Integer subtotal;
	@Column(name = "ACTIVESTATUS")
	private String activestatus;
	@Column(name = "MODIFIEDON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;
	@Column(name = "ADDEDON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date addedOn;
	@Column(name = "USERID")
	private String userid;
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getUnittype() {
		return unittype;
	}
	public void setUnittype(String unittype) {
		this.unittype = unittype;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}
	public String getActivestatus() {
		return activestatus;
	}
	public void setActivestatus(String activestatus) {
		this.activestatus = activestatus;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public Date getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(activestatus, addedOn, modifiedOn, price, productid, productname, quantity, subtotal,
				unittype, userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryList other = (InventoryList) obj;
		return Objects.equals(activestatus, other.activestatus) && Objects.equals(addedOn, other.addedOn)
				&& Objects.equals(modifiedOn, other.modifiedOn) && Objects.equals(price, other.price)
				&& Objects.equals(productid, other.productid) && Objects.equals(productname, other.productname)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(subtotal, other.subtotal)
				&& Objects.equals(unittype, other.unittype) && Objects.equals(userid, other.userid);
	}
	
	@Override
	public String toString() {
		return "InventoryList [productid=" + productid + ", productname=" + productname + ", quantity=" + quantity
				+ ", unittype=" + unittype + ", price=" + price + ", subtotal=" + subtotal + ", activestatus="
				+ activestatus + ", modifiedOn=" + modifiedOn + ", addedOn=" + addedOn + ", userid=" + userid + "]";
	}
	
	
}
