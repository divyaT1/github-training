package com.KrystalMovies.FoodMobsAPI.Model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderidPk implements Serializable {

	@Basic(optional = false)
	@Column(name = "ORDERID")
	private String orderid;
	@Column(name = "DISHID")
	private String dishid;
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getDishid() {
		return dishid;
	}
	public void setDishid(String dishid) {
		this.dishid = dishid;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dishid, orderid);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderidPk other = (OrderidPk) obj;
		return Objects.equals(dishid, other.dishid) && Objects.equals(orderid, other.orderid);
	}
	
	@Override
	public String toString() {
		return "OrderidPk [orderid=" + orderid + ", dishid=" + dishid + "]";
	}
	
	
	
}
