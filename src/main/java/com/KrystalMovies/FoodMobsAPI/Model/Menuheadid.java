package com.KrystalMovies.FoodMobsAPI.Model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENUHEADID")
public class Menuheadid implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Integer id;
	@Column(name = "PREFIX")
	private String prefix;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, prefix);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menuheadid other = (Menuheadid) obj;
		return Objects.equals(id, other.id) && Objects.equals(prefix, other.prefix);
	}
	@Override
	public String toString() {
		return "Menuheadid [id=" + id + ", prefix=" + prefix + "]";
	}
	
	
}
