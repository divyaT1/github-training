package com.KrystalMovies.FoodMobsAPI.Service;

import java.util.Map;

public interface InventoryService {

	Map savenewproduct(Map jsonbody) throws Exception ;

	Map getstockdetails(Map jsonbody) throws Exception ;

	Map updateproduct(Map jsonbody) throws Exception ;

}
