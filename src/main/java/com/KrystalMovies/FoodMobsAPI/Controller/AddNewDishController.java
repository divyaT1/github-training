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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.KrystalMovies.FoodMobsAPI.Response.ObjectResponse;
import com.KrystalMovies.FoodMobsAPI.Response.Standards;
import com.KrystalMovies.FoodMobsAPI.Response.StatusType;
import com.KrystalMovies.FoodMobsAPI.Service.AddNewDishService;


@SuppressWarnings("unused")
@RestController
@RequestMapping("/addnewdishcontroller")
@CrossOrigin(origins="*")
public class AddNewDishController {

	@Autowired
	AddNewDishService addNewDishService;
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/savenewdish")
	public ResponseEntity saveNewDish(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = addNewDishService.saveNewDish(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/updatenewdish")
	public ResponseEntity updateNewDish(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = addNewDishService.updateNewDish(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/getnewdish")
	public ResponseEntity getNewDish(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = addNewDishService.getNewDish(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/getspeciallist")
	public ResponseEntity getSpecialList(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = addNewDishService.getSpecialList(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/getdisheslist")
	public ResponseEntity getdisheslist(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = addNewDishService.getdisheslist(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
}
