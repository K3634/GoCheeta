package com.codewithkrishanthi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import java.util.List;

import com.codewithkrishanthi.model.Category;

public class CategoryDao {
	
	
	static FactoryDao factory = new FactoryDao();
	static DbConnector connector = factory.getDb("MySql");
	
	public static Category getTheCategoryBycategoryID(int categoryID) throws ClassNotFoundException, SQLException {
		
		//Establish the connection
		
		Connection connection = connector.getConnection();
		
		
		//4.create the statement/prepared statement
		//String query = "SELECT * FROM categories WHERE cID = " + categoryID;
		// Statement st = connection.createStatement();
		
		
		
		String query = "SELECT * FROM category WHERE categoryID = ?";
	    PreparedStatement ps = connection.prepareStatement(query);
	    ps.setInt(1, categoryID);
	    
	    
	    //5.Execute the query
	    ResultSet rs = ps.executeQuery();
	    
	    
	    //6.Evaluate the response result set
	    Category category  = new Category();;
	    if(rs.next()) 
	    {
	    	category.setCategoryID(rs.getInt("categoryID"));
	    	category.setVehicleNo(rs.getString("vehicleNo"));
	    	category.setVehicleName(rs.getString("vehicleName"));
	    	category.setBranchName(rs.getString("branchName"));
	    	category.setPrice(rs.getInt("price"));
	    	category.setDriverID(rs.getString("driverID"));
	    	category.setDriverName(rs.getString("driverName"));
	    	category.setDriverAddress(rs.getString("driverAddress"));
	    	category.setDriverTP(rs.getString("driverTP"));

	    }	
	    //7. close the statement and the connection
	    	ps.close();
	    	connection.close();
	    	return category;
			
		}
	
	public static List<Category>getAllCategory() throws ClassNotFoundException, SQLException{
		
		

		Connection connection = connector.getConnection();
		
		
		String query = "SELECT * FROM category";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Category> category1 = new  ArrayList<Category>();
		
		
		while(rs.next()) {
			
			Category category = new Category(rs.getInt("categoryID"),rs.getString("vehicleNo"),rs.getString("vehicleName"),rs.getString("branchName"),rs.getInt("price"), rs.getString("driverID"),rs.getString("driverName"), rs.getString("driverAddress"), rs.getString("driverTP"));
			category1.add(category);
		}
		
		st.close();
		connection.close();
		return category1;
		
		
		}
	
	public static  boolean addCategory(Category category) throws ClassNotFoundException, SQLException {
		
		
	
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO category (vehicleNo,VehicleName,branchName,Price,driverID,driverName,driverAddress,driverTP) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1,category.getVehicleNo());
		ps.setString(2,category.getVehicleName());
		ps.setString(3,category.getBranchName());
		ps.setDouble(4,category.getPrice());
		ps.setString(5,category.getDriverID());
		ps.setString(6,category.getDriverName());
		ps.setString(7,category.getDriverAddress());
		ps.setString(8,category.getDriverTP());
		
		
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
	
	public static boolean updateCategory(Category category) throws ClassNotFoundException, SQLException {
		

		Connection connection = connector.getConnection();
		
		String query = "UPDATE category SET vehicleNo=?,vehicleName=?,branchName=?,price=?,driverID=?,driverName=?,driverAddress=?,driverTP=? WHERE categoryID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1,category.getVehicleNo());
		ps.setString(2,category.getVehicleName());
		ps.setString(3,category.getBranchName());
		ps.setInt(4,category.getPrice());
		ps.setString(5,category.getDriverID());
		ps.setString(6,category.getDriverName());
		ps.setString(7,category.getDriverAddress());
		ps.setString(8,category.getDriverTP());
		ps.setInt(9,category.getCategoryID());
		
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
	
	public static boolean deleteCategory(int categoryID) throws ClassNotFoundException, SQLException {
		
	
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM category WHERE categoryID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1,categoryID);
		
		
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
		
	}

}