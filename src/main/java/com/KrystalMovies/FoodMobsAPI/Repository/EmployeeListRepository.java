package com.KrystalMovies.FoodMobsAPI.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.KrystalMovies.FoodMobsAPI.Model.EmployeeList;

@Repository
public interface EmployeeListRepository extends CrudRepository<EmployeeList, String>{

	@Query("select max(el.employeeid) from EmployeeList el")
	List getlastidno();

	@Query("select new Map(empl.employeeid as employeeid, empl.employeename as employeename, "
			+ " empl.formonthyear as formonthyear, empl.employeepost as employeepost, "
			+ " empl.userid as userid, empl.activestatus as activestatus, empl.imagename as imagename) "
			+ " from EmployeeList empl")
	List<Map> getemplist();

	@Modifying
	@Query("Update EmployeeList empl Set empl.employeename=:employeename, empl.formonthyear=:formonthyear, "
			+ " empl.employeepost=:employeepost, empl.userid=:userid, empl.activestatus=:activestatus,"
			+ " empl.imagename=:imagename, empl.modifiedOn=:modifiedon where empl.employeeid=:empid ")
	void updateEmpdata(String employeename, String empid, String formonthyear, String employeepost, 
			String activestatus, String imagename, String userid, Date modifiedon);

}
