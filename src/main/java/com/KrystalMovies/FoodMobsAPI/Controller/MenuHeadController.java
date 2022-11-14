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
import com.KrystalMovies.FoodMobsAPI.Service.MenuHeadService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/menuheadcontroller")
@CrossOrigin(origins="*")
public class MenuHeadController {

	@Autowired
	MenuHeadService menuHeadService;
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/savemenuhead")
	public ResponseEntity saveMenuhead(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = menuHeadService.saveMenuhead(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/updatemenuhead")
	public ResponseEntity updateMenuhead(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = menuHeadService.updateMenuhead(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/getmenuhead")
	public ResponseEntity getMenuhead(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = menuHeadService.getMenuhead(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
}
