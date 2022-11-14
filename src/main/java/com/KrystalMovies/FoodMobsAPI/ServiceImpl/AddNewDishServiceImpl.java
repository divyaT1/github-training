package com.KrystalMovies.FoodMobsAPI.ServiceImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.KrystalMovies.FoodMobsAPI.Model.Dishid;
import com.KrystalMovies.FoodMobsAPI.Model.MenuDishList;
import com.KrystalMovies.FoodMobsAPI.Repository.DishidRepository;
import com.KrystalMovies.FoodMobsAPI.Repository.MenuDishListRepository;
import com.KrystalMovies.FoodMobsAPI.Service.AddNewDishService;

@Service
public class AddNewDishServiceImpl implements AddNewDishService{

	@Autowired
	MenuDishListRepository menuDishListRepository;
	
	@Autowired
	DishidRepository dishidRepository;
	
	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Override
	public Map saveNewDish(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			List menudishlist = new ArrayList();
			
//			menudishlist = (List) jsonbody.get("menudishlist");
			
//			for(int i = 0; i < menudishlist.size(); i++) {
//				
//			Map map1 = new HashMap();
//			map1 = (Map) menudishlist.get(i);
			
			MenuDishList menuDish = new MenuDishList();
			
			List idlist = getvendoridgenrated();
			String dishid = ((Map) idlist.get(0)).get("id").toString();

//			menuDish.setActivestatus("Y");
//			menuDish.setAddedOn(new Date());
//			menuDish.setDescription(map1.get("dishdetails").toString());
//			menuDish.setDishid(dishid);
//			menuDish.setDishname(map1.get("dishname").toString());
//			menuDish.setFullrate(Integer.valueOf(map1.get("fullrate").toString()));
//			menuDish.setHalfrate(Integer.valueOf(map1.get("halfrate").toString()));
//			menuDish.setImagename(map1.get("imagename").toString());
//			menuDish.setModifiedOn(new Date());
//			menuDish.setMenuheadid(map1.get("menuhead").toString());
//			menuDish.setSpecialdish(map1.get("specialdishes").toString());
//			menuDish.setUserid(map1.get("userid").toString());
			
			menuDish.setActivestatus("Y");
			menuDish.setAddedOn(new Date());
			menuDish.setDescription(jsonbody.get("dishdetails").toString());
			menuDish.setDishid(dishid);
			menuDish.setDishname(jsonbody.get("dishname").toString());
			menuDish.setFullrate(Integer.valueOf(jsonbody.get("fullrate").toString()));
			menuDish.setHalfrate(Integer.valueOf(jsonbody.get("halfrate").toString()));
			menuDish.setImagename(jsonbody.get("imagename").toString());
			menuDish.setModifiedOn(new Date());
			menuDish.setMenuheadid(jsonbody.get("menuhead").toString());
			menuDish.setSpecialdish(jsonbody.get("specialdishes").toString());
			menuDish.setUserid(jsonbody.get("userid").toString());
			
			menuDishListRepository.save(menuDish);
			
//			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}
	
//	generateid
	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	public List getvendoridgenrated() {
		List idlist = new ArrayList();
		Map map = new HashMap();
		try {
			String id = "";
			String idn = "";
			String prefix = "dishid";
			int idno = 0 ;
			
			List idList = menuDishListRepository.getlastidno();
			
			if(idList.size() == 0 || idList.get(0) == null)
			{
				idno = 0001;
				id = prefix + "0001";				
			} else {
				String idnumber = idList.get(0).toString();
				
				idno = Integer.valueOf(idnumber);
				
				String idnum = "";
				if (idno == 0) {
					idnum = "1";
				} else {
					idno = idno + 1;
					idnum = String.valueOf(idno);
				}
				idn = idnum;
				id = prefix + idnum;
			}
			map.put("id", id);
			
			Dishid dishid = new Dishid();
			
			dishid.setId(idno);
			dishid.setPrefix(prefix);
			
			dishidRepository.save(dishid);
			
			idlist.add(map);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return idlist;
	}


	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Transactional
	@Override
	public Map updateNewDish(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			String dishid			= jsonbody.get("dishid").toString();
			String dishname      	= jsonbody.get("dishname").toString();
			String dishdetails   	= jsonbody.get("dishdetails").toString();
			String halfrate 		= jsonbody.get("halfrate").toString();
			String fullrate      	= jsonbody.get("fullrate").toString();
			String specialdishes 	= jsonbody.get("specialdishes").toString();
			String menuhead      	= jsonbody.get("menuhead").toString();
			String imagename     	= jsonbody.get("imagename").toString();
			String userid        	= jsonbody.get("userid").toString();
			String activestatus		= jsonbody.get("activestatus").toString(); 
			Date modifiedon 		= new Date();
			
			menuDishListRepository.updatemenudishs(dishid, dishname, dishdetails, halfrate, fullrate, specialdishes, 
					menuhead, imagename, userid, activestatus, modifiedon);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Override
	public Map getNewDish(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			String userid = jsonbody.get("userid").toString();
			
			List<Map> menudishlist = new ArrayList<Map>();
			menudishlist = menuDishListRepository.getdishlist(userid);
			map.put("menudishlist", menudishlist);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Override
	public Map getSpecialList(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			String userid = jsonbody.get("userid").toString();
			
			List<Map> specialList = new ArrayList<Map>();
			specialList = menuDishListRepository.getSpecialList(userid);
			map.put("specialList", specialList);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	@Override
	public Map getdisheslist(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			String userid = jsonbody.get("userid").toString();
		
			List<Map> menudishlist = new ArrayList<Map>();
			menudishlist = menuDishListRepository.getdisheslist(userid);
			map.put("menudishlist", menudishlist);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}


}
