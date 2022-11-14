package com.KrystalMovies.FoodMobsAPI.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KrystalMovies.FoodMobsAPI.Model.EmployeeList;
import com.KrystalMovies.FoodMobsAPI.Repository.EmployeeListRepository;
import com.KrystalMovies.FoodMobsAPI.Service.EmployeeOFMonthService;

@Service
public class EmployeeOFMonthServiceImpl implements EmployeeOFMonthService{

	@Autowired
	EmployeeListRepository employeeListRepository;
	
	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Override
	public Map saveNewEmpOfMonth(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			EmployeeList employeeList = new EmployeeList();
			
			List idlist = getvendoridgenrated();
			String empid = ((Map) idlist.get(0)).get("id").toString();
			
			employeeList.setActivestatus("Y");
			employeeList.setAddedOn(new Date());
			employeeList.setEmployeeid(empid);
			employeeList.setEmployeename(jsonbody.get("employeename").toString());
			employeeList.setEmployeepost(jsonbody.get("employeepost").toString());
			employeeList.setFormonthyear(jsonbody.get("monthfor").toString());
			employeeList.setImagename(jsonbody.get("imagename").toString());
			employeeList.setModifiedOn(new Date());
			employeeList.setUserid(jsonbody.get("userid").toString());
			
			employeeListRepository.save(employeeList);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Transactional
	@Override
	public Map updateEmpOfMonth(Map jsonbody) throws Exception {
		Map map = new HashMap();
		try {
			String empid = jsonbody.get("empid").toString();
			String employeename = jsonbody.get("employeename").toString();
			String formonthyear = jsonbody.get("formonthyear").toString();
			String employeepost = jsonbody.get("employeepost").toString();
			String activestatus = jsonbody.get("activestatus").toString();
			String imagename = jsonbody.get("imagename").toString();
			String userid = jsonbody.get("userid").toString();
			Date modifiedon = new Date();
			
			employeeListRepository.updateEmpdata(employeename, empid, formonthyear, employeepost, 
					activestatus, imagename, userid, modifiedon);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@Override
	public Map getEmpOfMonthList() throws Exception {
		Map map = new HashMap();
		try {
			List<Map> employeeList = new ArrayList<Map>();
			employeeList = employeeListRepository.getemplist();
			map.put("employeeList", employeeList);
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
			
			List idList = employeeListRepository.getlastidno();
			
			if(idList.get(0) == null)
			{
				id = "emprefid#1";
			} else {
				String lastid = idlist.get(0).toString();
				String[] idlast = lastid.split("#");
				String idnumber = idlast[1];
				
				int idno = Integer.valueOf(idnumber);
				
				String idnum = "";
				if (idno == 0) {
					idnum = "1";
				} else {
					idno = idno + 1;
					idnum = String.valueOf(idno);
				}
				id = "emprefid#" + idnum;
			}
			map.put("id", id);
			
			idlist.add(map);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return idlist;
	}

}
