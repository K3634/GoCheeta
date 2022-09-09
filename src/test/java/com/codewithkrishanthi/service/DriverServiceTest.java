package com.codewithkrishanthi.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.codewithkrishanthi.model.Driver;

class DriverServiceTest {

	@Test
	void testAddDriver() throws ClassNotFoundException, SQLException {
		DriverService service = new DriverService();
		Driver driver  = new Driver();;
		boolean expected = true;
		boolean actual = service.addDriver(driver);
		assertEquals(expected,actual,"The addCatergory was sent");
	}

}
