package com.KrystalMovies.FoodMobsAPI.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.KrystalMovies.FoodMobsAPI.Model.Menuheadid;

@Repository
public interface MenuheadidRepository extends CrudRepository<Menuheadid, String>{

}
