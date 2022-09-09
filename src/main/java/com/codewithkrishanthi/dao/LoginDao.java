package com.codewithkrishanthi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codewithkrishanthi.model.Register;

public class LoginDao {
	
	static FactoryDao factory = new FactoryDao();
	static DbConnector connector = factory.getDb("MySql");
	
	public static Register authenticateUser(Register register) throws ClassNotFoundException, SQLException {
	
	String uName = register.getuName();
	String uPassword = register.getuPassword();
	

	Connection connection =connector.getConnection();
//	PreparedStatement pp=null;
	String query ="select uName,uPassword,urole_ID from register where uPassword = ?";
	PreparedStatement ps = connection.prepareStatement(query);
	ps.setString(1, uPassword);
	
//	statement = connection.createStatement();
//	resultSet = statement.executeQuery("select userName,userPassword,roleID from users where userPassword = " + password);
	
	ResultSet rs = ps.executeQuery();
	Register register1 = new Register();

	if(rs.next()) {
		 
		register1.setuName(rs.getString("uName"));
		register1.setuPassword(rs.getString("uPassword"));
		register1.setUrole_ID(rs.getInt("urole_ID"));
		
	}
	ps.close();
	connection.close();
	return register1;
}

}
