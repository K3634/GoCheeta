package com.codewithkrishanthi.service;

import static org.junit.jupiter.api.Assertions.*;


import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.codewithkrishanthi.model.Booking;
import com.codewithkrishanthi.model.Category;

class BookingServiceTest {




	@Test
	void testAddCategory() throws ClassNotFoundException, SQLException {
		BookingService  service = new BookingService();
		Booking booking  = new Booking();;
		boolean expected = true;
		boolean actual = service.addBooking(booking);
		assertEquals(expected,actual,"The addBooking was sent");
	}



}
