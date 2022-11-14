package com.KrystalMovies.FoodMobsAPI.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.KrystalMovies.FoodMobsAPI.Model.Dishid;

@Repository
public interface DishidRepository extends CrudRepository<Dishid, String> {

}
