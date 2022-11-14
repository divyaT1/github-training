package com.KrystalMovies.FoodMobsAPI.Model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CartListPk implements Serializable {

	@Basic(optional = false)
	@Column(name = "CARTID")
	private String cartid;
	@Column(name = "DISHID")
	private String dishid;
	
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public String getDishid() {
		return dishid;
	}
	public void setDishid(String dishid) {
		this.dishid = dishid;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cartid, dishid);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartListPk other = (CartListPk) obj;
		return Objects.equals(cartid, other.cartid) && Objects.equals(dishid, other.dishid);
	}
	
	@Override
	public String toString() {
		return "CartListPk [cartid=" + cartid + ", dishid=" + dishid + "]";
	}
	
	
}
