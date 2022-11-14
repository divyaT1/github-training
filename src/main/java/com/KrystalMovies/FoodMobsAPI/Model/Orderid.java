package com.KrystalMovies.FoodMobsAPI.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ORDERID")
public class Orderid implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	protected OrderidPk orderidPk;
	
	@Column(name = "ACTIVESTATUS")
	private String activestatus;
	@Column(name = "DISHNAME")
	private String dishname;
	@Column(name = "USERID")
	private String userid;
	@Column(name = "IMAGENAME")
	private String imagename;
	@Column(name = "ORDERFROM")
	private String orderfrom ;
	@Column(name = "QUANTITY")
	private Integer quantity;
	@Column(name = "SUBTOTAL")
	private Integer subtotal;
	@Column(name = "TOTAL")
	private Integer total;
	@Column(name = "RATE")
	private Integer rate;
	@Column(name = "ORDERSTATUS")
	private String orderstatus;
	@Column(name = "CUSTOMERNAME")
	private String customername;
	@Column(name = "CUSTOMERNUMBER")
	private String customernumber;
	@Column(name = "MODIFIEDON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;
	@Column(name = "ADDEDON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date addedOn;
	
	public OrderidPk getOrderidPk() {
		return orderidPk;
	}
	public void setOrderidPk(OrderidPk orderidPk) {
		this.orderidPk = orderidPk;
	}
	public String getActivestatus() {
		return activestatus;
	}
	public void setActivestatus(String activestatus) {
		this.activestatus = activestatus;
	}
	public String getDishname() {
		return dishname;
	}
	public void setDishname(String dishname) {
		this.dishname = dishname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getOrderfrom() {
		return orderfrom;
	}
	public void setOrderfrom(String orderfrom) {
		this.orderfrom = orderfrom;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomernumber() {
		return customernumber;
	}
	public void setCustomernumber(String customernumber) {
		this.customernumber = customernumber;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(activestatus, addedOn, customername, customernumber, dishname, imagename, modifiedOn,
				orderfrom, orderidPk, orderstatus, quantity, rate, subtotal, total, userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orderid other = (Orderid) obj;
		return Objects.equals(activestatus, other.activestatus) && Objects.equals(addedOn, other.addedOn)
				&& Objects.equals(customername, other.customername)
				&& Objects.equals(customernumber, other.customernumber) && Objects.equals(dishname, other.dishname)
				&& Objects.equals(imagename, other.imagename) && Objects.equals(modifiedOn, other.modifiedOn)
				&& Objects.equals(orderfrom, other.orderfrom) && Objects.equals(orderidPk, other.orderidPk)
				&& Objects.equals(orderstatus, other.orderstatus) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(rate, other.rate) && Objects.equals(subtotal, other.subtotal)
				&& Objects.equals(total, other.total) && Objects.equals(userid, other.userid);
	}
	@Override
	public String toString() {
		return "Orderid [orderidPk=" + orderidPk + ", activestatus=" + activestatus + ", dishname=" + dishname
				+ ", userid=" + userid + ", imagename=" + imagename + ", orderfrom=" + orderfrom + ", quantity="
				+ quantity + ", subtotal=" + subtotal + ", total=" + total + ", rate=" + rate + ", orderstatus="
				+ orderstatus + ", customername=" + customername + ", customernumber=" + customernumber
				+ ", modifiedOn=" + modifiedOn + ", addedOn=" + addedOn + "]";
	}
	
	
}
