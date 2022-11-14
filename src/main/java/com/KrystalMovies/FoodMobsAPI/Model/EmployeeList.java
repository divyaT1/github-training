package com.KrystalMovies.FoodMobsAPI.Model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPLOYEELIST")
public class EmployeeList {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "EMPLOYEEID")
	private String employeeid;
	@Column(name = "EMPLOYEENAME")
	private String employeename;
	@Column(name = "FORMONTHYEAR")
	private String formonthyear;
	@Column(name = "EMPLOYEEPOST")
	private String employeepost;
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
	@Column(name = "IMAGENAME")
	private String imagename;
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getFormonthyear() {
		return formonthyear;
	}
	public void setFormonthyear(String formonthyear) {
		this.formonthyear = formonthyear;
	}
	public String getEmployeepost() {
		return employeepost;
	}
	public void setEmployeepost(String employeepost) {
		this.employeepost = employeepost;
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
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(activestatus, addedOn, employeeid, employeename, employeepost, formonthyear, imagename,
				modifiedOn, userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeList other = (EmployeeList) obj;
		return Objects.equals(activestatus, other.activestatus) && Objects.equals(addedOn, other.addedOn)
				&& Objects.equals(employeeid, other.employeeid) && Objects.equals(employeename, other.employeename)
				&& Objects.equals(employeepost, other.employeepost) && Objects.equals(formonthyear, other.formonthyear)
				&& Objects.equals(imagename, other.imagename) && Objects.equals(modifiedOn, other.modifiedOn)
				&& Objects.equals(userid, other.userid);
	}
	@Override
	public String toString() {
		return "EmployeeList [employeeid=" + employeeid + ", employeename=" + employeename + ", formonthyear="
				+ formonthyear + ", employeepost=" + employeepost + ", userid=" + userid + ", activestatus="
				+ activestatus + ", modifiedOn=" + modifiedOn + ", addedOn=" + addedOn + ", imagename=" + imagename
				+ "]";
	}
}
