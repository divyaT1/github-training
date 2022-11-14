package com.KrystalMovies.FoodMobsAPI.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.KrystalMovies.FoodMobsAPI.Model.CartList;
import com.KrystalMovies.FoodMobsAPI.Model.CartListPk;

@Repository
public interface CartListRepository extends CrudRepository<CartList, CartListPk>{

	@Query("select max(car.id) from Cartids car")
	List getlastidno();

}
