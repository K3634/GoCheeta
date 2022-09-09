package com.codewithkrishanthi.service;

import java.sql.SQLException;

import java.util.List;

import com.codewithkrishanthi.dao.CategoryDao;
import com.codewithkrishanthi.model.Category;



public class CategoryService {
	
   public Category getTheCategoryBycategoryID(int categoryID) throws ClassNotFoundException, SQLException {
	   
    return CategoryDao.getTheCategoryBycategoryID(categoryID);        
	         	
   }

   public List<Category>getAllCategory() throws ClassNotFoundException, SQLException{
	   
	   return CategoryDao.getAllCategory();
   }
   
   public boolean addCategory(Category category) throws ClassNotFoundException, SQLException {
	   
	   return CategoryDao.addCategory(category);
   }
   
   public boolean updateCategory(Category category) throws ClassNotFoundException, SQLException {
	   
	   return CategoryDao.updateCategory(category);
   }
   
   public boolean deleteCategory(int categoryID) throws ClassNotFoundException, SQLException {
	   
	   return CategoryDao.deleteCategory(categoryID);
   }
   
   
   
   
   
   
}




