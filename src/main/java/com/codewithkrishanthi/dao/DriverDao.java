package com.codewithkrishanthi.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.codewithkrishanthi.model.Driver;



public class DriverDao {
	
	static FactoryDao factory = new FactoryDao();
	static DbConnector connector = factory.getDb("MySql");

	public static Driver getTheDriverBydID(int dID) throws ClassNotFoundException, SQLException {
		
		//Establish the connection
		
		Connection connection = connector.getConnection();
		
		
		//4.create the statement/prepared statement
		//String query = "SELECT * FROM categories WHERE cID = " + categoryID;
		// Statement st = connection.createStatement();
		
		
		
		String query = "SELECT * FROM driver WHERE dID = ?";
	    PreparedStatement ps = connection.prepareStatement(query);
	    ps.setInt(1, dID);
	    
	    
	    //5.Execute the query
	    ResultSet rs = ps.executeQuery();
	    
	    
	    //6.Evaluate the response result set
	    Driver driver  = new Driver();;
	    if(rs.next()) 
	    {
	    	 driver.setdID(rs.getInt("dID"));
	    	 driver.setDriverName(rs.getString("driverName"));
	    	 driver.setDriverAddress(rs.getString("driverAddress"));
	    	 driver.setDriverTP(rs.getString("driverTP"));
	    	 driver.setBranchName(rs.getString("branchName"));
	    	
	    }	
	    //7. close the statement and the connection
	    	ps.close();
	    	connection.close();
	    	return driver;
			
		}
	
	public static List<Driver>getAllDriver() throws ClassNotFoundException, SQLException{
		
		

		Connection connection = connector.getConnection();
		
		
		String query = "SELECT * FROM driver";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Driver> Driver1 = new  ArrayList<Driver>();
		
		
		while(rs.next()) {
			
			Driver driver = new Driver(rs.getInt("dID"),rs.getString("driverName"),rs.getString("driverAddress"),rs.getString("driverTP"),rs.getString("branchName"));
			Driver1.add(driver);
		}
		
		st.close();
		connection.close();
		return Driver1;
		
		
		}
public static  boolean addDriver(Driver driver) throws ClassNotFoundException, SQLException {
		
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO driver (driverName,driverAddress,driverTP,branchName) VALUES (?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1,driver.getDriverName());
		ps.setString(2,driver.getDriverAddress());
		ps.setString(3,driver.getDriverTP());
		ps.setString(4,driver.getBranchName());
		
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
		
	}	

public static boolean updateDriver(Driver driver) throws ClassNotFoundException, SQLException {
		

		Connection connection = connector.getConnection();
		
		String query = "UPDATE driver SET driverName=?,DriverAddress=?,DriverTP=?,branchName=? WHERE dID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		
		ps.setString(1,driver.getDriverName());
		ps.setString(2,driver.getDriverAddress());
		ps.setString(3,driver.getDriverTP());
		ps.setString(4,driver.getBranchName());	
		ps.setInt(5,driver.getdID());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
	
public static boolean deleteDriver(int dID) throws ClassNotFoundException, SQLException {
		
	
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM driver WHERE dID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1,dID);
		
		
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
		
	}	
}
