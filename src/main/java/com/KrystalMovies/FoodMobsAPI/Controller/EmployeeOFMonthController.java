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
import com.KrystalMovies.FoodMobsAPI.Service.EmployeeOFMonthService;


@SuppressWarnings("unused")
@RestController
@RequestMapping("/employeeofmonthcontroller")
@CrossOrigin(origins="*")
public class EmployeeOFMonthController {

	@Autowired
	EmployeeOFMonthService employeeOFMonthService;
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/savenewempofmonth")
	public ResponseEntity saveNewEmpOfMonth(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = employeeOFMonthService.saveNewEmpOfMonth(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/updateempofmonth")
	public ResponseEntity updateEmpOfMonth(@RequestBody Map jsonbody) throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = employeeOFMonthService.updateEmpOfMonth(jsonbody);
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
	
	@SuppressWarnings({"rawtypes"})
	@PostMapping("/getempofmonthlist")
	public ResponseEntity getEmpOfMonthList() throws Exception	{
		Map map = new HashMap();
		final ObjectResponse<Object> objectResponseName = new ObjectResponse<Object>();
		try {
			map = employeeOFMonthService.getEmpOfMonthList();
			objectResponseName.setResponse(map);
			objectResponseName.setStatus(new StatusType(Standards.SUCCESS));
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body(objectResponseName);
		}
	}
}
