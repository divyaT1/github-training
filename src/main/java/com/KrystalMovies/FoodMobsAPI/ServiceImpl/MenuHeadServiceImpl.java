package com.KrystalMovies.FoodMobsAPI.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KrystalMovies.FoodMobsAPI.Model.Dishid;
import com.KrystalMovies.FoodMobsAPI.Model.MenuHeadList;
import com.KrystalMovies.FoodMobsAPI.Model.Menuheadid;
import com.KrystalMovies.FoodMobsAPI.Repository.MenuHeadListRepository;
import com.KrystalMovies.FoodMobsAPI.Repository.MenuheadidRepository;
import com.KrystalMovies.FoodMobsAPI.Service.MenuHeadService;

@Service
public class MenuHeadServiceImpl implements MenuHeadService{

	@Autowired
	MenuHeadListRepository menuHeadListRepository;
	
	@Autowired
	MenuheadidRepository menuheadidRepository;
	
	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Override
	public Map saveMenuhead(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			List menuhead = new ArrayList();
			
			menuhead = (List) jsonbody.get("menuheadlist");
			
			for(int i = 0 ; i < menuhead.size(); i++) {
			
			Map map1 = new HashMap();
			map1 = (Map) menuhead.get(i);
			
			MenuHeadList mhl = new MenuHeadList();
			List<Map> ids = getvendoridgenrated();
			
			String menuheadid = ids.get(0).get("id").toString();
			
			mhl.setActivestatus(map1.get("activestatus").toString());
			mhl.setAddedOn(new Date());
			mhl.setMenuheadid(menuheadid);
			mhl.setMenuheadname(map1.get("menuheadname").toString());
			mhl.setMenuheadtype(map1.get("menuheadtype").toString());
			mhl.setModifiedOn(new Date());
			mhl.setUserid(map1.get("userid").toString());
			
			menuHeadListRepository.save(mhl);
			
			}
			
//			MenuHeadList mhl = new MenuHeadList();
//			List<Map> ids = getvendoridgenrated();
//			
//			String menuheadid = ids.get(0).get("id").toString();
//			
//			mhl.setActivestatus("Y");
//			mhl.setAddedOn(new Date());
//			mhl.setMenuheadid(menuheadid);
//			mhl.setMenuheadname(jsonbody.get("menuheadname").toString());
//			mhl.setMenuheadtype(jsonbody.get("menuheadtype").toString());
//			mhl.setModifiedOn(new Date());
//			mhl.setUserid(jsonbody.get("userid").toString());
//			
//			menuHeadListRepository.save(mhl);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Override
	public Map updateMenuhead(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			MenuHeadList mhl = new MenuHeadList();

			
			
			mhl = menuHeadListRepository.findById(jsonbody.get("menuheadid").toString()).orElse(null);
			
			mhl.setActivestatus(jsonbody.get("activestatus").toString());
			mhl.setMenuheadname(jsonbody.get("menuheadname").toString());
			mhl.setMenuheadtype(jsonbody.get("menuheadtype").toString());
			mhl.setAddedOn(new Date());
			mhl.setModifiedOn(new Date());
			mhl.setUserid(jsonbody.get("userid").toString());

			menuHeadListRepository.save(mhl);
		} catch(Exception ex) {
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
			String prefix = "menuhead#";
			int idno = 0 ;
			
			List idList = menuHeadListRepository.getlastidno();
			
			if(idList.size() == 0 || idList.get(0) == null)
			{
				idno = 0001;
				id = prefix + "1";				
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
			
			Menuheadid dishid = new Menuheadid();
			
			dishid.setId(idno);
			dishid.setPrefix(prefix);
			
			menuheadidRepository.save(dishid);
			
			idlist.add(map);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return idlist;
	}

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Override
	public Map getMenuhead(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			String userid = jsonbody.get("userid").toString();
			
			List<Map> menuheadlist = new ArrayList<Map>();
			menuheadlist = menuHeadListRepository.getheadlist(userid);
			map.put("menuheadlist", menuheadlist);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}
	
}
