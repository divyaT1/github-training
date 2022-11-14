package com.KrystalMovies.FoodMobsAPI.Service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public interface OrdersService {

	Map generateCart(Map jsonbody) throws Exception	;

	Map generateOrder(Map jsonbody) throws Exception ;

	Map updateOrder(Map jsonbody) throws Exception ;

	Map getOrders(Map jsonbody) throws Exception ;

	Map updateorderstatus(Map jsonbody) throws Exception ;

	Map getcartlist(Map jsonbody) throws Exception ;

	Map removecart(Map jsonbody) throws Exception ;

	Map wgenerateOrder(Map jsonbody) throws Exception ;

	byte[] printslip(HttpServletResponse response1, Map jsonbody) throws Exception ;


}
