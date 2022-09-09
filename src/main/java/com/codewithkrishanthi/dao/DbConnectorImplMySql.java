package com.codewithkrishanthi.dao;

import java.sql.Connection;

 
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectorImplMySql implements DbConnector{

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		// 2.load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
				
		//.3.establish the connection
		String url = "jdbc:mysql://127.0.0.1:3306/cabdb";
		String userName = "krishanthi";
		String password = "krish";
				
		return DriverManager.getConnection(url,userName,password);
				
	}
	
	

}
