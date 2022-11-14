package com.KrystalMovies.FoodMobsAPI.Service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface AddNewDishService {

	Map saveNewDish(Map jsonbody) throws Exception ;

	Map updateNewDish(Map jsonbody) throws Exception ;

	Map getNewDish(Map jsonbody) throws Exception ;

	Map getSpecialList(Map jsonbody) throws Exception ;

	Map getdisheslist(Map jsonbody) throws Exception ;
}