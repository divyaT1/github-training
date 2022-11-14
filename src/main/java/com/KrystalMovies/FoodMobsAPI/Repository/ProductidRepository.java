package com.KrystalMovies.FoodMobsAPI.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.KrystalMovies.FoodMobsAPI.Model.Productid;

@Repository
public interface ProductidRepository extends CrudRepository<Productid, String>{

}
