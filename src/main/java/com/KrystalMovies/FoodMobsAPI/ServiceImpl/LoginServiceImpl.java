package com.KrystalMovies.FoodMobsAPI.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KrystalMovies.FoodMobsAPI.Repository.LoginRepository;
import com.KrystalMovies.FoodMobsAPI.Service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepository loginRepository;
	
	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Override
	public Map validatelogin(Map jsonbody) throws Exception {
		Map map = new HashMap<>();
		try {
			String userid = jsonbody.get("userid").toString();
			String password = jsonbody.get("password").toString();
			
			List<Map> login_info = new ArrayList<Map>();
			
			login_info = loginRepository.getlogininfo(userid, password);
			map.put("logininfo", login_info);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

}
