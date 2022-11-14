package com.KrystalMovies.FoodMobsAPI.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.KrystalMovies.FoodMobsAPI.Model.InventoryList;

@Repository
public interface InventoryListRepository extends CrudRepository<InventoryList, String>{

	@Query("select max(orid.id) from Orderids orid")
	List getlastidno();

	@Query("select new Map(ilt.productid as productid, ilt.productname as productname, ilt.quantity as quantity, "
			+ "ilt.unittype as unittype, ilt.price as price, ilt.subtotal as subtotal, ilt.activestatus as activestatus, "
			+ "ilt.userid as userid) From InventoryList ilt where ilt.userid=:userid")
	List<Map> getstockdetails(String userid);

	@Modifying
	@Query("Update InventoryList ilt Set ilt.productname=:productname , ilt.quantity=:quantity , ilt.unittype=:unittype , "
			+ " ilt.price=:price , ilt.subtotal=:subtotal , ilt.activestatus=:activestatus, ilt.modifiedOn=:modifiedOn "
			+ " where ilt.userid=:userid and ilt.productid=:productid")
	void updateproduct(String userid, String productid, String productname, int quantity, String unittype, int price,
			int subtotal, String activestatus, Date modifiedOn);
	
	
}
