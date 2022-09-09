package com.codewithkrishanthi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.codewithkrishanthi.model.Feedback;

public class FeedbackDao {
	
	static FactoryDao factory = new FactoryDao();
	static DbConnector connector = factory.getDb("MySql");
	

	public static  boolean addFeedback(Feedback feedback) throws ClassNotFoundException, SQLException {
		
		
	
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO feedback (cName,des) VALUES (?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1,feedback.getDes());
		ps.setString(2,feedback.getcName());
		
		
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}

}
