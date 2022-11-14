package com.KrystalMovies.FoodMobsAPI.Controller;

import java.util.HashMap;
import java.util.Map;

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
import com.KrystalMovies.FoodMobsAPI.Service.InventoryService;


@SuppressWarnings("unused")
@RestController
@RequestMapping("/inventorycontroller")
@CrossOrigin(origins="*")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/savenewproduct")
	public ResponseEntity savenewproduct(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = inventoryService.savenewproduct(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/getstockdetails")
	public ResponseEntity getstockdetails(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = inventoryService.getstockdetails(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}

	@SuppressWarnings({"rawtypes"})
	@PostMapping("/updateproduct")
	public ResponseEntity updateproduct(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = inventoryService.updateproduct(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
}
