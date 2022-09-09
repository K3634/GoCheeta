package com.codewithkrishanthi.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithkrishanthi.model.Booking;



public class BookingDao {
	
	static FactoryDao factory = new FactoryDao();
	static DbConnector connector = factory.getDb("MySql");
	
	public static Booking getTheBookingByb_ID(int b_ID) throws ClassNotFoundException, SQLException {
		
		//Establish the connection

		Connection connection = connector.getConnection();
		
		
		String query = "SELECT * FROM booking WHERE b_ID = ?";
	    PreparedStatement ps = connection.prepareStatement(query);
	    ps.setInt(1, b_ID);
	    
	    
	    //5.Execute the query
	    ResultSet rs = ps.executeQuery();
	    
	    
	    //6.Evaluate the response result set
	    Booking booking  = new Booking();;
	    if(rs.next()) 
	    {
	    	
	    	booking.setB_ID(rs.getInt("b_ID"));
	    	booking.setcName(rs.getString("cName"));
	    	booking.setPickUp(rs.getString("pickUp"));
	    	booking.setDropUp(rs.getString("dropUp"));
	    	booking.setvCat(rs.getString("vCat"));
	    	booking.setB_date(rs.getString("b_date"));
	    	booking.setPay(rs.getInt("pay"));
	    }	
	    //7. close the statement and the connection
	    	ps.close();
	    	connection.close();
	    	return booking;
			
		}


		
	
	public static List<Booking>getAllBooking() throws ClassNotFoundException, SQLException{
		
	
		Connection connection = connector.getConnection();
		
		
		String query = "SELECT * FROM booking";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Booking> booking1 = new  ArrayList<Booking>();
		
		
		while(rs.next()) {
			
			Booking booking = new Booking(rs.getInt("b_ID"),rs.getString("cName"),rs.getString("pickUp"),rs.getString("dropUp"),rs.getString("vCat"),rs.getString("b_date"),rs.getInt("pay"));
			booking1.add(booking);
		}
		
		st.close();
		connection.close();
		return booking1;
		
		
		}
	
	public static  boolean addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		
		
		
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO booking (cName,pickUp,dropUp,vCat,b_date,pay) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1,booking.getcName());
		ps.setString(2,booking.getPickUp());
		ps.setString(3,booking.getDropUp());
		ps.setString(4,booking.getvCat());
		ps.setString(5,booking.getB_date());
		ps.setInt(6,booking.getPay());
		
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
	
	public static boolean updateBooking(Booking booking) throws ClassNotFoundException, SQLException {
		
		
		Connection connection = connector.getConnection();
		
		String query = "UPDATE booking SET cName=?,pickUp=?,dropUp=?,vCat=?,b_date=?,pay=? WHERE b_ID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1,booking.getcName());
		ps.setString(2,booking.getPickUp());
		ps.setString(3,booking.getDropUp());
		ps.setString(4,booking.getvCat());
		ps.setString(5,booking.getB_date());
		ps.setInt(6,booking.getPay());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}

	public static boolean deleteBooking(int b_ID) throws ClassNotFoundException, SQLException {
	
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM booking WHERE b_ID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1,b_ID);
		
		
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
		
	}


}