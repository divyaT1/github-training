package com.KrystalMovies.FoodMobsAPI.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KrystalMovies.FoodMobsAPI.Model.Dishid;
import com.KrystalMovies.FoodMobsAPI.Model.InventoryList;
import com.KrystalMovies.FoodMobsAPI.Model.Productid;
import com.KrystalMovies.FoodMobsAPI.Repository.InventoryListRepository;
import com.KrystalMovies.FoodMobsAPI.Repository.ProductidRepository;
import com.KrystalMovies.FoodMobsAPI.Service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	InventoryListRepository inventoryListRepository;
	
	@Autowired
	ProductidRepository productidRepository;
	
	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Override
	public Map savenewproduct(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			List idlist = getvendoridgenrated();
			String prodid = ((Map) idlist.get(0)).get("id").toString();
			
			InventoryList inventoryList = new InventoryList();
			if(jsonbody.get("activestatus").toString().equals("true")) {				
				inventoryList.setActivestatus("Y");
			}
			if(jsonbody.get("activestatus").toString().equals("false")) {				
				inventoryList.setActivestatus("N");
			}
			inventoryList.setAddedOn(new Date());
			inventoryList.setModifiedOn(new Date());
			inventoryList.setPrice(Integer.valueOf(jsonbody.get("price").toString()));
			inventoryList.setProductid(prodid);
			inventoryList.setProductname(jsonbody.get("productname").toString());
			inventoryList.setQuantity(Integer.valueOf(jsonbody.get("quantity").toString()));
			inventoryList.setSubtotal(Integer.valueOf(jsonbody.get("subtotal").toString()));
			inventoryList.setUnittype(jsonbody.get("unittype").toString());
			inventoryList.setUserid(jsonbody.get("userid").toString());
			
			inventoryListRepository.save(inventoryList);
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
			String prefix = "Prod_";
			int idno = 0 ;
			
			List idList = inventoryListRepository.getlastidno();
			
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
			
			Productid dishid = new Productid();
			
			dishid.setId(idno);
			dishid.setPrefix(prefix);
			
			productidRepository.save(dishid);
			
			idlist.add(map);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return idlist;
	}

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Override
	public Map getstockdetails(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			String userid = jsonbody.get("userid").toString();
			
			List<Map> stockdetails = new ArrayList<Map>();
			stockdetails = inventoryListRepository.getstockdetails(userid);
			map.put("stockdetails", stockdetails);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Transactional
	@Override
	public Map updateproduct(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			String userid = jsonbody.get("userid").toString();
			String  productid= jsonbody.get("userid").toString();
	        String productname = jsonbody.get("userid").toString();
	        int quantity = Integer.valueOf(jsonbody.get("userid").toString());
	        String unittype = jsonbody.get("userid").toString();
	        int price = Integer.valueOf(jsonbody.get("userid").toString());
	        int subtotal  = Integer.valueOf(jsonbody.get("userid").toString());
	        String activestatus = "";
	        if(jsonbody.get("userid").toString().equals("true")) {
	        	activestatus = "Y";
	        } else if(jsonbody.get("userid").toString().equals("false")) {
	        	activestatus = "N";
	        }
	        Date modifiedOn = new Date();
			
			inventoryListRepository.updateproduct(userid, productid, productname, quantity, unittype, price,
					subtotal, activestatus, modifiedOn);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

}
