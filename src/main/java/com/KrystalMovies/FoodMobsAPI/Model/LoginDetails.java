package com.KrystalMovies.FoodMobsAPI.Model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class LoginDetails implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "userId")
	private String userid;
	@Column(name = "password")
	private String password;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(password, userid);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDetails other = (LoginDetails) obj;
		return Objects.equals(password, other.password) && Objects.equals(userid, other.userid);
	}
	
	@Override
	public String toString() {
		return "LoginDetails [userid=" + userid + ", password=" + password + "]";
	}
}
