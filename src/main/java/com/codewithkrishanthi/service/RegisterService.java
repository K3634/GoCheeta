package com.codewithkrishanthi.service;

import java.sql.SQLException;

import com.codewithkrishanthi.dao.RegisterDao;
import com.codewithkrishanthi.model.Register;

public class RegisterService {
	
public  boolean addCustomer(Register register) throws ClassNotFoundException, SQLException {
		
		return RegisterDao.addCustomer(register);
	}

}
