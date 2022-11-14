package com.KrystalMovies.FoodMobsAPI.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.KrystalMovies.FoodMobsAPI.Model.MenuDishList;

@Repository
public interface MenuDishListRepository extends CrudRepository<MenuDishList, String>{

//	@Query("select max(md.dishid) from MenuDishList md")
	@Query("select max(md.id) from Dishid md")
	List getlastidno();

	@Query("select new Map(md.menuheadid as menuhead, md.dishid as dishid, md.activestatus as activestatus,"
			+ " md.dishname as dishname, md.userid as userid, md.description as description,"
			+ " md.specialdish as specialdish, md.halfrate as halfrate, md.fullrate as fullrate,"
			+ " md.imagename as imagename) from MenuDishList md where md.userid=:userid")
	List<Map> getdishlist(String userid);

	@Modifying
	@Query("Update MenuDishList md Set md.menuheadid=:menuhead, md.dishname=:dishname, md.description=:dishdetails,"
			+ " md.specialdish=:specialdishes, md.imagename=:imagename, md.halfrate=:halfrate, md.fullrate=:fullrate, "
			+ " md.activestatus=:activestatus, md.modifiedOn=:modifiedon, md.userid=:userid where md.dishid=:dishid")
	void updatemenudishs(String dishid, String dishname, String dishdetails, String halfrate, String fullrate,
			String specialdishes, String menuhead, String imagename, String userid, String activestatus,
			Date modifiedon);

	@Query("select new Map(md.menuheadid as menuheadid, md.dishid as dishid, md.activestatus as activestatus,"
			+ " md.dishname as dishname, md.userid as userid, md.description as description,"
			+ " md.specialdish as specialdish, md.halfrate as halfrate, md.fullrate as fullrate,"
			+ " md.imagename as imagename) from MenuDishList md where md.userid=:userid and md.specialdish='Y' "
			+ " and md.activestatus='Y' ")
	List<Map> getSpecialList(String userid);

	@Query("select new Map(md.menuheadid as menuheadid, md.dishid as dishid, md.activestatus as activestatus,"
			+ " md.dishname as dishname, md.userid as userid, md.description as description,"
			+ " md.specialdish as specialdish, md.halfrate as halfrate, md.fullrate as fullrate,"
			+ " md.imagename as imagename, md.salecount as salecount) from MenuDishList md "
			+ "where md.userid=:userid order by md.salecount desc")
	List<Map> getdisheslist(String userid);
}
