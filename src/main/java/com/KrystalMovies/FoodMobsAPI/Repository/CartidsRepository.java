package com.KrystalMovies.FoodMobsAPI.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.KrystalMovies.FoodMobsAPI.Model.Cartids;

@Repository
public interface CartidsRepository extends CrudRepository<Cartids, String>{

}
