package com.codewithkrishanthi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.codewithkrishanthi.model.Register;

public class RegisterDao {

	static FactoryDao factory = new FactoryDao();
	static DbConnector connector = factory.getDb("MySql");
	
public static boolean addCustomer(Register register) throws ClassNotFoundException, SQLException {
		
	
		Connection connection =connector.getConnection();
		
		String query = "Insert into register (uName,address,contactNo,branchName,uPassword,urole_ID) values (?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, register.getuName());
		ps.setString(2, register.getAddress());
		ps.setString(3, register.getContactNo());
		ps.setString(4, register.getBranchName());
		ps.setString(5, register.getuPassword());
		ps.setInt(6, register.getUrole_ID());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	} 
}
