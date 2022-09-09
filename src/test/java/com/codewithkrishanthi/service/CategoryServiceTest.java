package com.codewithkrishanthi.service;

import static org.junit.jupiter.api.Assertions.*;


import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.codewithkrishanthi.model.Category;

class CategoryServiceTest {



	@Test
	void testAddCategory() throws ClassNotFoundException, SQLException {
		CategoryService service = new CategoryService();
		Category category  = new Category();;
		boolean expected = true;
		boolean actual = service.addCategory(category);
		assertEquals(expected,actual,"The addCatergory was sent");
	}

	
}
