package com.codewithkrishanthi.service;

import java.sql.SQLException;

import com.codewithkrishanthi.dao.FeedbackDao;
import com.codewithkrishanthi.model.Feedback;

public class FeedbackService {
	
	 public boolean addFeedback(Feedback feedback) throws ClassNotFoundException, SQLException {
		   
		   return FeedbackDao.addFeedback(feedback);
	   }

}
