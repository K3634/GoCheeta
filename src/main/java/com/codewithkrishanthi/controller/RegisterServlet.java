package com.codewithkrishanthi.controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithkrishanthi.model.Register;
import com.codewithkrishanthi.service.RegisterService;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterServlet() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("add")) {
			addCustomer(request,response);
		}
		
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		   String message = "";
		   RegisterService service = new RegisterService();
		   
		   Register register= new Register();
		   register.setuName(request.getParameter("uName"));
		   register.setAddress(request.getParameter("address"));
		   register.setContactNo(request.getParameter("contactNo"));
		   register.setBranchName(request.getParameter("branchName"));
		   register.setuPassword(request.getParameter("uPassword"));
		   register.setUrole_ID(Integer.parseInt(request.getParameter("urole_ID")));
		   try {
			boolean result = service.addCustomer(register);
			 if(result) {
				 request.setAttribute("status", "success");
			 }
			 else {
				 request.setAttribute("status", "failed");
			 }
		   } catch (ClassNotFoundException | SQLException e) {
			   
			   request.setAttribute("status", "error");
		   }
		   
		    request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		   
	   }
}
