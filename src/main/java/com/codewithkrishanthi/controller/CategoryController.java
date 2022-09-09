package com.codewithkrishanthi.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codewithkrishanthi.model.Category;
import com.codewithkrishanthi.service.CategoryService;

/**
 * Servlet implementation class CategoryController
 */
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			
			getAllCategory(request,response);
		}
		else {
			
			getSpecificCategory(request,response);
		}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action= request.getParameter("action");
		
		
		if(action.equals("add")) {
			
		    addCategory(request,response);			
		}
		else if((action.equals("update"))){
			
			updateCategory(request,response);
			
		}
		else if(action.equals("delete")) {
			
			deleteCategory(request,response);
		}
	}

	private void getAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		CategoryService service = new CategoryService();
		try {
			
			List<Category>category = service.getAllCategory();
			
			
			if(category.isEmpty())
			{
				message = "There's no any category to show";	
			}
			
			request.setAttribute("categoryList",category);
			
		}       
		
		catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("category-jstl-example.jsp");
		rd.forward(request,response);
	}
	
	private void getSpecificCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message=" ";
		CategoryService service = new CategoryService();
		int categoryID= Integer.parseInt(request.getParameter("categoryID")); 
		
		Category category = new Category();
		try {
			category = service.getTheCategoryBycategoryID(categoryID);
			
			if(category.getVehicleName().isEmpty()) {
				
				message = "There's no any category under category ID : "+ categoryID;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message",message);
		request.setAttribute("category",category);
		
		RequestDispatcher rd = request.getRequestDispatcher("search-edit.jsp");
		rd.forward(request, response);
	}
	
	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		String message = " ";
		CategoryService service = new CategoryService();
		
		Category category = new Category();
		category.setVehicleNo(request.getParameter("vehicleNo"));
		category.setVehicleName(request.getParameter("vehicleName"));
		category.setBranchName(request.getParameter("branchName"));
		category.setPrice(Integer.parseInt(request.getParameter("price")));
		category.setDriverID(request.getParameter("driverID"));
		category.setDriverName(request.getParameter("driverName"));
		category.setDriverAddress(request.getParameter("driverAddress"));
		category.setDriverTP(request.getParameter("driverTP"));
		
		try {
			boolean result = service.addCategory(category);
			if(result) {
				message = "The category has been added succesfully Vehicle Name:"+ category.getVehicleName();
			}else {
				message = "Failed to updtate category !Vehicle Name : "+ category.getVehicleName();
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-category.jsp");
		rd.forward(request,response);
	}
    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String message = "";
    	CategoryService service = new CategoryService();
    	
    	Category category = new Category();
    	category.setCategoryID(Integer.parseInt(request.getParameter("categoryID")));
    	category.setVehicleNo(request.getParameter("vehicleNo"));
		category.setVehicleName(request.getParameter("vehicleName"));
		category.setBranchName(request.getParameter("branchName"));
		category.setPrice(Integer.parseInt(request.getParameter("price")));
		category.setDriverID(request.getParameter("driverID"));
		category.setDriverName(request.getParameter("driverName"));
		category.setDriverAddress(request.getParameter("driverAddress"));
		category.setDriverTP(request.getParameter("driverTP"));
    	
    	try {
			boolean result = service.updateCategory(category);
			if(result) {
				message = "The category has been updated successfully! Category ID : "+ category.getCategoryID();
			}
			else {
				message = "Failed to updtate category ! Category ID : "+ category.getCategoryID();
			}
		} 
    	
    	catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
		}
    	
    	request.setAttribute("message",message);
    	RequestDispatcher rd = request.getRequestDispatcher("search-edit.jsp");
		rd.forward(request,response);
	}
	
    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
    	String message = "";
    	int categoryID = Integer.parseInt(request.getParameter("categoryID"));
    	CategoryService service = new CategoryService();
    	try {
			service.deleteCategory(categoryID);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			
     }
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("deleteMessage",message);
    	response.sendRedirect("/GoCheeta/getCategory?action=all");
}

	
}