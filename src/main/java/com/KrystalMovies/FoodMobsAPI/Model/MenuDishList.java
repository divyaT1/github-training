package com.KrystalMovies.FoodMobsAPI.Model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MENUDISHLIST")
public class MenuDishList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "DISHID")
	private String dishid;
	@Column(name = "MENUHEADID")
	private String menuheadid;
	@Column(name = "ACTIVESTATUS")
	private String activestatus;
	@Column(name = "DISHNAME")
	private String dishname;
	@Column(name = "USERID")
	private String userid;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "SPECIALDISH")
	private String specialdish;
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
	@Column(name = "SALECOUNT")
	private Integer salecount;
	public String getDishid() {
		return dishid;
	}
	public void setDishid(String dishid) {
		this.dishid = dishid;
	}
	public String getMenuheadid() {
		return menuheadid;
	}
	public void setMenuheadid(String menuheadid) {
		this.menuheadid = menuheadid;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSpecialdish() {
		return specialdish;
	}
	public void setSpecialdish(String specialdish) {
		this.specialdish = specialdish;
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
	public Integer getSalecount() {
		return salecount;
	}
	public void setSalecount(Integer salecount) {
		this.salecount = salecount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(activestatus, addedOn, description, dishid, dishname, fullrate, halfrate, imagename,
				menuheadid, modifiedOn, salecount, specialdish, userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuDishList other = (MenuDishList) obj;
		return Objects.equals(activestatus, other.activestatus) && Objects.equals(addedOn, other.addedOn)
				&& Objects.equals(description, other.description) && Objects.equals(dishid, other.dishid)
				&& Objects.equals(dishname, other.dishname) && Objects.equals(fullrate, other.fullrate)
				&& Objects.equals(halfrate, other.halfrate) && Objects.equals(imagename, other.imagename)
				&& Objects.equals(menuheadid, other.menuheadid) && Objects.equals(modifiedOn, other.modifiedOn)
				&& Objects.equals(salecount, other.salecount) && Objects.equals(specialdish, other.specialdish)
				&& Objects.equals(userid, other.userid);
	}
	@Override
	public String toString() {
		return "MenuDishList [dishid=" + dishid + ", menuheadid=" + menuheadid + ", activestatus=" + activestatus
				+ ", dishname=" + dishname + ", userid=" + userid + ", description=" + description + ", specialdish="
				+ specialdish + ", halfrate=" + halfrate + ", fullrate=" + fullrate + ", modifiedOn=" + modifiedOn
				+ ", addedOn=" + addedOn + ", imagename=" + imagename + ", salecount=" + salecount + "]";
	}
		
}
