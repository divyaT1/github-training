package com.KrystalMovies.FoodMobsAPI.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CARTLIST")
public class CartList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	protected CartListPk cartListPk;
	
	@Column(name = "SUBTOTAL")
	private Integer subtotal;
	@Column(name = "DISHNAME")
	private String dishname;
	@Column(name = "USERID")
	private String userid;
	@Column(name = "QUANTITY")
	private Integer quantity ;
	@Column(name = "RATE")
	private Integer rate;
	@Column(name = "HALFRATE")
	private Integer halfrate;
	@Column(name = "FULLRATE")
	private Integer fullrate;
	@Column(name = "MODIFIEDON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;
	@Column(name = "ADDEDON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date addedOn;
	@Column(name = "IMAGENAME")
	private String imagename;
	@Column(name = "CARTSTATUS")
	private String cartstatus;
	public CartListPk getCartListPk() {
		return cartListPk;
	}
	public void setCartListPk(CartListPk cartListPk) {
		this.cartListPk = cartListPk;
	}
	public Integer getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Integer getHalfrate() {
		return halfrate;
	}
	public void setHalfrate(Integer halfrate) {
		this.halfrate = halfrate;
	}
	public Integer getFullrate() {
		return fullrate;
	}
	public void setFullrate(Integer fullrate) {
		this.fullrate = fullrate;
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
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getCartstatus() {
		return cartstatus;
	}
	public void setCartstatus(String cartstatus) {
		this.cartstatus = cartstatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(addedOn, cartListPk, cartstatus, dishname, fullrate, halfrate, imagename, modifiedOn,
				quantity, rate, subtotal, userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartList other = (CartList) obj;
		return Objects.equals(addedOn, other.addedOn) && Objects.equals(cartListPk, other.cartListPk)
				&& Objects.equals(cartstatus, other.cartstatus) && Objects.equals(dishname, other.dishname)
				&& Objects.equals(fullrate, other.fullrate) && Objects.equals(halfrate, other.halfrate)
				&& Objects.equals(imagename, other.imagename) && Objects.equals(modifiedOn, other.modifiedOn)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(rate, other.rate)
				&& Objects.equals(subtotal, other.subtotal) && Objects.equals(userid, other.userid);
	}
	@Override
	public String toString() {
		return "CartList [cartListPk=" + cartListPk + ", subtotal=" + subtotal + ", dishname=" + dishname + ", userid="
				+ userid + ", quantity=" + quantity + ", rate=" + rate + ", halfrate=" + halfrate + ", fullrate="
				+ fullrate + ", modifiedOn=" + modifiedOn + ", addedOn=" + addedOn + ", imagename=" + imagename
				+ ", cartstatus=" + cartstatus + "]";
	}
}
