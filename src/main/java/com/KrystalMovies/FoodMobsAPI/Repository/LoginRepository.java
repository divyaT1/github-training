package com.KrystalMovies.FoodMobsAPI.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.KrystalMovies.FoodMobsAPI.Model.LoginDetails;

@Repository
public interface LoginRepository extends CrudRepository<LoginDetails, String>{

	@Query("select new Map(ld.userid as userid, ld.password as password) from LoginDetails ld where ld.userid = :userid and ld.password = :password")
	List<Map> getlogininfo(String userid, String password);

}