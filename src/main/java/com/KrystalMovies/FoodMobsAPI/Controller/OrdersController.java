package com.KrystalMovies.FoodMobsAPI.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KrystalMovies.FoodMobsAPI.Response.ObjectResponse;
import com.KrystalMovies.FoodMobsAPI.Response.Standards;
import com.KrystalMovies.FoodMobsAPI.Response.StatusType;
import com.KrystalMovies.FoodMobsAPI.Service.AddNewDishService;
import com.KrystalMovies.FoodMobsAPI.Service.OrdersService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/orderscontroller")
@CrossOrigin(origins="*")
public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/generatecart")
	public ResponseEntity generateCart(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = ordersService.generateCart(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/getcartlist")
	public ResponseEntity getcartlist(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = ordersService.getcartlist(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/removecart")
	public ResponseEntity removecart(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = ordersService.removecart(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/generateorder")
	public ResponseEntity generateOrder(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = ordersService.generateOrder(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/wgenerateorder")
	public ResponseEntity wgenerateOrder(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = ordersService.wgenerateOrder(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/updateorder")
	public ResponseEntity updateOrder(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = ordersService.updateOrder(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/getorders")
	public ResponseEntity getOrders(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = ordersService.getOrders(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/updateorderstatus")
	public ResponseEntity updateorderstatus(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = ordersService.updateorderstatus(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/printslip")
	public ResponseEntity<byte[]> printslip(HttpServletResponse response1, @RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		ResponseEntity<byte[]> response = null;
		byte [] pdffile ;
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			pdffile = ordersService.printslip(response1, jsonbody);
			response = new ResponseEntity<>(pdffile, HttpStatus.OK);
			return response;
		} catch(Exception ex) {
			ex.printStackTrace();
			return response;
		}
	}
	
}
