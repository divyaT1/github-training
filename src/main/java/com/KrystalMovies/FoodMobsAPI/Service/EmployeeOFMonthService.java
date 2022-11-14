package com.KrystalMovies.FoodMobsAPI.Service;

import java.util.Map;

public interface EmployeeOFMonthService {

	Map saveNewEmpOfMonth(Map jsonbody)  throws Exception	;

	Map updateEmpOfMonth(Map jsonbody) throws Exception	;

	Map getEmpOfMonthList() throws Exception	;

}
