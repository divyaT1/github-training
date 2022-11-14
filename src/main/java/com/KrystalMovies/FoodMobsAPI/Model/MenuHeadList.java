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
@Table(name = "MENUHEADLIST")
public class MenuHeadList implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "MENUHEADID")
	private String menuheadid;
	@Column(name = "MENUHEADNAME")
	private String menuheadname;
	@Column(name = "MENUHEADTYPE")
	private String menuheadtype;
	@Column(name = "USERID")
	private String userid;
	@Column(name = "ACTIVESTATUS")
	private String activestatus;
	@Column(name = "MODIFIEDON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;
	@Column(name = "ADDEDON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date addedOn;
	
	public String getMenuheadid() {
		return menuheadid;
	}
	public void setMenuheadid(String menuheadid) {
		this.menuheadid = menuheadid;
	}
	public String getMenuheadname() {
		return menuheadname;
	}
	public void setMenuheadname(String menuheadname) {
		this.menuheadname = menuheadname;
	}
	public String getMenuheadtype() {
		return menuheadtype;
	}
	public void setMenuheadtype(String menuheadtype) {
		this.menuheadtype = menuheadtype;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(activestatus, addedOn, menuheadid, menuheadname, menuheadtype, modifiedOn, userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuHeadList other = (MenuHeadList) obj;
		return Objects.equals(activestatus, other.activestatus) && Objects.equals(addedOn, other.addedOn)
				&& Objects.equals(menuheadid, other.menuheadid) && Objects.equals(menuheadname, other.menuheadname)
				&& Objects.equals(menuheadtype, other.menuheadtype) && Objects.equals(modifiedOn, other.modifiedOn)
				&& Objects.equals(userid, other.userid);
	}
	@Override
	public String toString() {
		return "MenuHeadList [menuheadid=" + menuheadid + ", menuheadname=" + menuheadname + ", menuheadtype="
				+ menuheadtype + ", userid=" + userid + ", activestatus=" + activestatus + ", modifiedOn=" + modifiedOn
				+ ", addedOn=" + addedOn + "]";
	}
	
	
}