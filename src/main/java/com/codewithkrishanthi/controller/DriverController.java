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

import com.codewithkrishanthi.model.Driver;
import com.codewithkrishanthi.service.DriverService;

/**
 * Servlet implementation class DriverController
 */
public class DriverController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");
			
         if(action.equals("all")) {
			
	         getAllDriver(request,response);
		}
		else {
			
			getSpecificDriver(request,response);
		}	
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
          String action= request.getParameter("action");
		
                   if(action.equals("add")) {
	
                       addDriver(request,response);			
                   }
                  else if((action.equals("update"))){
	
	                updateDriver(request,response);
	
                    }
                  else if(action.equals("delete")) {
	
	                  deleteDriver(request,response);
          }
}
	
private void getAllDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String message = "";
			DriverService service = new DriverService();
			try {
				
				List<Driver>driver = service.getAllDriver();
				
				
				if(driver.isEmpty())
				{
					message = "There's no any Driver to show";	
				}
				
				request.setAttribute("driverList",driver);
				
			}       
			
			catch (ClassNotFoundException | SQLException e) {
				
				message = e.getMessage();
			}
			
			request.setAttribute("message", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("driver-jstl-example.jsp");
			rd.forward(request,response);
		}
		
		private void getSpecificDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String message=" ";
			DriverService service = new DriverService();
			int dID= Integer.parseInt(request.getParameter("dID")); 
			
			Driver driver = new Driver();
			try {
				driver = service.getTheDriverBydID(dID);
				
				if(driver.getDriverName().isEmpty()) {
					
					message = "There's no any driver under Driver ID : "+ dID;
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			request.setAttribute("message",message);
			request.setAttribute("driver",driver);
			
			RequestDispatcher rd = request.getRequestDispatcher("search-edit-driver.jsp");
			rd.forward(request, response);
		}

		
		private void addDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			   
			   String message = "";
			   DriverService service = new DriverService();
			   
			   Driver driver= new Driver();
			   driver.setDriverName(request.getParameter("driverName"));
			   driver.setDriverAddress(request.getParameter("driverAddress"));
			   driver.setDriverTP(request.getParameter("driverTP"));
			   driver.setBranchName(request.getParameter("branchName"));
			   try {
				boolean result = service.addDriver(driver);
				 if(result) {
					message = "This driver has been added successfully! Driver Name:" + driver.getDriverName();
				 }
				 else {
					 message = "Failed to add the Driver! Driver Name:" + driver.getDriverName();
				 }
			   } catch (ClassNotFoundException | SQLException e) {
				   message = e.getMessage();
			   }
			   
			   request.setAttribute("message", message);	
				RequestDispatcher rd = request.getRequestDispatcher("add-driver.jsp");
				rd.forward(request, response);
			   
		   }

		  private void updateDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		    	String message = "";
		    	DriverService service = new DriverService();
		    	
		    	Driver driver = new Driver();
		    	   driver.setdID(Integer.parseInt(request.getParameter("dID")));
		    	   driver.setDriverName(request.getParameter("driverName"));
				   driver.setDriverAddress(request.getParameter("driverAddress"));
				   driver.setDriverTP(request.getParameter("driverTP"));
				   driver.setBranchName(request.getParameter("branchName"));
		    	
		    	
		    	try {
					boolean result = service.updateDriver(driver);
					if(result) {
						message = "The category has been updated successfully! Driver ID : "+ driver.getdID();
					}
					else {
						message = "Failed to updtate category ! Driver ID : "+ driver.getdID();
					}
				} 
		    	
		    	catch (ClassNotFoundException | SQLException e) {

		            message = e.getMessage();
				}
		    	
		    	request.setAttribute("message",message);
		    	RequestDispatcher rd = request.getRequestDispatcher("search-edit-driver.jsp");
				rd.forward(request,response);
			}
			
		    private void deleteDriver(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
		    	String message = "";
		    	int dID = Integer.parseInt(request.getParameter("dID"));
		    	DriverService service = new DriverService();
		    	try {
					service.deleteDriver(dID);
				} catch (ClassNotFoundException | SQLException e) {
					message = e.getMessage();
					
		     }
		    	
		    	HttpSession session = request.getSession();
		    	session.setAttribute("deleteMessage",message);
		    	response.sendRedirect("/GoCheeta/getDriver?action=all");
		}
		
}
