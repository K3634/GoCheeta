package com.codewithkrishanthi.service;

import java.sql.SQLException;

import java.util.List;

import com.codewithkrishanthi.dao.BookingDao;
import com.codewithkrishanthi.model.Booking;





public class BookingService {
	
public Booking getTheBookingByb_ID(int b_ID) throws ClassNotFoundException, SQLException {
		   
	    return BookingDao.getTheBookingByb_ID(b_ID);        
		         	
	   }
	
public  boolean addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		
		return BookingDao.addBooking(booking);
	}

public List<Booking>getAllBooking() throws ClassNotFoundException, SQLException{
	   
	   return BookingDao.getAllBooking();
}

public boolean updateBooking(Booking booking) throws ClassNotFoundException, SQLException {
	   
	   return BookingDao.updateBooking(booking);
}
public boolean deleteBooking(int b_ID) throws ClassNotFoundException, SQLException {
	   
	   return BookingDao.deleteBooking(b_ID);
}

}
