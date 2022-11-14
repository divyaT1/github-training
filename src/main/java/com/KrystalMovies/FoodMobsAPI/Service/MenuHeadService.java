package com.KrystalMovies.FoodMobsAPI.Service;

import java.util.Map;

public interface MenuHeadService {

	Map saveMenuhead(Map jsonbody) throws Exception	;

	Map updateMenuhead(Map jsonbody) throws Exception ;

	Map getMenuhead(Map jsonbody) throws Exception ;

}
