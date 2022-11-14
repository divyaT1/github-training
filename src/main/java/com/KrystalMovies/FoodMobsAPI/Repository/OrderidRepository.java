package com.KrystalMovies.FoodMobsAPI.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.KrystalMovies.FoodMobsAPI.Model.Orderid;
import com.KrystalMovies.FoodMobsAPI.Model.OrderidPk;
import com.KrystalMovies.FoodMobsAPI.Model.Orderids;

@Repository 
public interface OrderidRepository extends CrudRepository<Orderid, OrderidPk>{

	@Modifying
	@Query("Update Orderid odi Set odi.id.dishid=:dishid, odi.activestatus=:activestatus, odi.dishname=:dishname, "
			+ " odi.userid=:userid, odi.imagename=:imagename, odi.quantity=:quantity, odi.subtotal=:subtotal, "
			+ " odi.total=:total, odi.rate=:rate, odi.orderstatus=:orderstatus, odi.customername=:customername, "
			+ " odi.customernumber=:customernumber, odi.modifiedOn=:modifiedon where odi.id.orderid=:ordid")
	void updateoderlist(String ordid, String dishid, String activestatus, String dishname, String userid,
			String imagename, String orderstatus, String customername, String customernumber, int quantity,
			int subtotal, int total, int rate, Date modifiedon);

	@Query("select new Map (odi.id.orderid as orderid, odi.id.dishid as dishid, odi.activestatus as activestatus, "
			+ " odi.dishname as dishname, odi.userid as userid, odi.imagename as imagename, odi.addedOn as addedOn, "
			+ " odi.quantity as quantity, odi.subtotal as subtotal, odi.total as total, odi.rate as rate, "
			+ " odi.orderstatus as orderstatus, odi.customername as customername, odi.customernumber as customernumber, "
			+ " odi.orderfrom as orderfrom ) from Orderid odi where odi.userid=:userid group by odi.id.orderid order by odi.addedOn")
	List<Map> getOrders(String userid);

	@Query("select max(odi.id) from Orderids odi")
	List getlastidno();

	@Modifying
	@Query("Update Orderid odi Set odi.orderstatus=:orderstatus where odi.userid=:userid and odi.id.orderid=:orderid")
	void updateorderstatus(String userid, String orderid, String orderstatus);

	@Query("select new Map (odi.id.cartid as cartid, odi.id.dishid as dishid, odi.subtotal as subtotal, "
			+ " odi.dishname as dishname, odi.userid as userid, odi.imagename as imagename, odi.addedOn as addedOn, "
			+ " odi.quantity as quantity, odi.halfrate as halfrate, odi.fullrate as fullrate, odi.rate as rate, "
			+ " odi.cartstatus as cartstatus ) from CartList odi where odi.userid=:userid and odi.cartstatus='Y'")
	List<Map> getcartlist(String userid);

	@Modifying
	@Query("Update CartList odi Set odi.cartstatus=:cartstatus where odi.userid=:userid and odi.id.dishid=:dishid")
	void removecart(String userid, String dishid, String cartstatus);

	@Modifying
	@Query("Update CartList odi Set odi.cartstatus='N' where odi.userid=:userid and odi.id.cartid=:cartid")
	void updatecart(String cartid, String userid);

	@Query("select mdl.salecount from MenuDishList mdl where mdl.dishid=:dishid and mdl.userid=:userid")
	String getsalecount(String dishid, String userid);

	@Modifying
	@Query("Update MenuDishList odi Set odi.salecount=:salecount where odi.userid=:userid and odi.id.dishid=:dishid")
	void updatedishsales(String dishid, String userid, int salecount);

	@Query("select distinct count(odi.id.orderid) from Orderid odi where odi.userid=:userid and odi.addedOn=:todaysdate and "
			+ "odi.orderstatus <> 'C' group by odi.id.orderid ")
	String gettodaysorderonly(String userid, Date todaysdate);

	@Query("select new Map (odi.id.orderid as orderid, odi.id.dishid as dishid, odi.activestatus as activestatus, "
			+ " odi.dishname as dishname, odi.userid as userid, odi.imagename as imagename, odi.addedOn as addedOn, "
			+ " odi.quantity as quantity, odi.subtotal as subtotal, odi.total as total, odi.rate as rate, "
			+ " odi.orderstatus as orderstatus, odi.customername as customername, odi.customernumber as customernumber, "
			+ " odi.orderfrom as orderfrom ) from Orderid odi where odi.userid=:userid and odi.id.orderid=:orderid")
	List<Map> getorderdata(String userid, String orderid);

}