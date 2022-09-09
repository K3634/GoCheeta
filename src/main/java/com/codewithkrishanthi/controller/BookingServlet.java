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

import com.codewithkrishanthi.model.Booking;
import com.codewithkrishanthi.service.BookingService;
import com.codewithkrishanthi.service.CategoryService;

/**
 * Servlet implementation class BookingServlet
 */
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String action = request.getParameter("action");
			
			if(action.equals("all")) {
				

				getAllBooking(request,response);
			}
	      else{
				
	      	getSpecificBooking(request,response);
				
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
		
		if(action.equals("add")) {
			
			addBooking(request,response);
			
		}else if((action.equals("update"))){
			
			updateBooking(request,response);
			
		}else if(action.equals("delete")) {
			
			deleteBooking(request,response);
		
		}
	}
		private void getAllBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String message = "";
			BookingService service = new BookingService();
			try {
				
				List<Booking>booking = service.getAllBooking();
				
				
				if(booking.isEmpty())
				{
					message = "There's no any booking to show";	
				}
				
				request.setAttribute("bookingList",booking);
				
			}       
			
			catch (ClassNotFoundException | SQLException e) {
				
				message = e.getMessage();
			}
			
			request.setAttribute("message", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("booking-jstl-example.jsp");
			rd.forward(request,response);
		}
		
	private void getSpecificBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   String message = "";
		   
		   BookingService service = new BookingService();
		   
		   int b_ID= Integer.parseInt(request.getParameter("b_ID")); 
		
		   Booking booking= new Booking();
		   
		   try {
			   
			   booking = service.getTheBookingByb_ID(b_ID);
			
			if(booking.getvCat().isEmpty()) {
				
				message = "There's no any category under b_ID : "+ b_ID;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message",message);
		request.setAttribute("booking",booking);
		
		RequestDispatcher rd = request.getRequestDispatcher("serach-edit-booking.jsp");
		rd.forward(request, response);
	}

	

		private void addBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			   
			   String message = "";
			   BookingService service = new BookingService();
			   
			   Booking booking= new Booking();
			   
			   booking.setcName(request.getParameter("cName"));
			   booking.setPickUp(request.getParameter("pickUp"));
			   booking.setDropUp(request.getParameter("dropUp"));
			   booking.setvCat(request.getParameter("vCat"));
			   booking.setB_date(request.getParameter("b_dat"));
			   booking.setPay(Integer.parseInt(request.getParameter("pay")));


			   try {
				boolean result = service.addBooking(booking);
				 if(result) {
					message = "This user has been booking successfully! booking Now:" + booking.getvCat();
				 }
				 else {
					 message = "Failed to add the vehicle category! booking Now:" + booking.getvCat();
				 }
			   } catch (ClassNotFoundException | SQLException e) {
				   message = e.getMessage();
			   }
			   
			   request.setAttribute("message", message);	
				RequestDispatcher rd = request.getRequestDispatcher("booking.jsp");
				rd.forward(request, response);
			   
		   }
		
		   private void updateBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
			   String message = "";
			   BookingService service = new BookingService();
			   
			   Booking booking= new Booking();
			   booking.setcName(request.getParameter("cName"));
			   booking.setPickUp(request.getParameter("pickUp"));
			   booking.setDropUp(request.getParameter("dropUp"));
			   booking.setvCat(request.getParameter("vCat"));
			   booking.setB_date(request.getParameter("b_dat"));
			   booking.setPay(Integer.parseInt(request.getParameter("pay")));
		    	
		    	try {
					boolean result = service.updateBooking(booking);
					if(result) {
						message = "The category has been updated successfully! Booking ID : "+ booking.getB_ID();
					}
					else {
						message = "Failed to updtate category ! Booking ID : "+ booking.getB_ID();
					}
				} 
		    	
		    	catch (ClassNotFoundException | SQLException e) {

		            message = e.getMessage();
				}
		    	
		    	request.setAttribute("message",message);
		    	RequestDispatcher rd = request.getRequestDispatcher("serach-edit-booking.jsp");
				rd.forward(request,response);
			}
		   
		   private void deleteBooking(HttpServletRequest request, HttpServletResponse response) throws IOException {
				
		    	String message = "";
		    	int b_ID = Integer.parseInt(request.getParameter("b_ID"));
		    	BookingService service = new BookingService();
		    	try {
					service.deleteBooking(b_ID);
				} catch (ClassNotFoundException | SQLException e) {
					message = e.getMessage();
					
		     }
		    	
		    	HttpSession session = request.getSession();
		    	session.setAttribute("deleteMessage",message);
		    	response.sendRedirect("/GoCheeta/getBooking?action=all");
		}
		   
}
