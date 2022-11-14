package com.KrystalMovies.FoodMobsAPI.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.KrystalMovies.FoodMobsAPI.Model.Orderids;

@Repository
public interface OrderidsRepository extends CrudRepository<Orderids, String>{

}
