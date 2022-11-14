package com.KrystalMovies.FoodMobsAPI.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.KrystalMovies.FoodMobsAPI.Model.MenuHeadList;

@Repository
public interface MenuHeadListRepository extends CrudRepository<MenuHeadList, String>{

	@Query("select max(mh.id) from Menuheadid mh")
	List getlastidno();

	@Query("select new Map( mh.menuheadid as menuhead, mh.menuheadname as menuheadname, "
			+ " mh.menuheadtype as menuheadtype, mh.userid as userid, "
			+ " mh.activestatus as activestatus ) from MenuHeadList mh where mh.userid=:userid")
	List<Map> getheadlist(String userid);

}
