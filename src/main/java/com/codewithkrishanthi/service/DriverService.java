package com.codewithkrishanthi.service;

import java.sql.SQLException;

import java.util.List;

import com.codewithkrishanthi.dao.DriverDao;

import com.codewithkrishanthi.model.Driver;



public class DriverService {

	public Driver getTheDriverBydID(int dID) throws ClassNotFoundException, SQLException {
		   
	    return DriverDao.getTheDriverBydID(dID);        
		         	
	   }

	   public List<Driver>getAllDriver() throws ClassNotFoundException, SQLException{
		   
		   return DriverDao.getAllDriver();
	   }
	
     public  boolean addDriver(Driver driver) throws ClassNotFoundException, SQLException {
		
		return DriverDao.addDriver(driver);
	   }
     public boolean updateDriver(Driver driver) throws ClassNotFoundException, SQLException {
	   
	   return DriverDao.updateDriver(driver);
       }

    public boolean deleteDriver(int dID) throws ClassNotFoundException, SQLException {
	   
	   return DriverDao.deleteDriver(dID);
     }

}
