package com.codewithkrishanthi.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codewithkrishanthi.dao.LoginDao;
import com.codewithkrishanthi.model.Register;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uName = request.getParameter("uName");
		String uPassword = request.getParameter("uPassword");

		Register register = new Register();

		register.setuName(uName);
		register.setuPassword(uPassword);

		LoginDao loginDao = new LoginDao();

		try
		{
			Register userValidate = LoginDao.authenticateUser(register);
            
			if(userValidate.getUrole_ID()==1)
			{
				System.out.println("Admin's Home");

				HttpSession session = request.getSession();
				
				session.setAttribute("Admin", uName);
				request.setAttribute("uName", uName);

				request.getRequestDispatcher("admin.jsp").forward(request, response);
			}
			else if(userValidate.getUrole_ID()==2)
			{
				System.out.println("Customer's Home");

				HttpSession session = request.getSession(); //Creating a session
				session.setAttribute("Customer", uName); //setting session attribute
				request.setAttribute("userName", uName);

				request.getRequestDispatcher("booking.jsp").forward(request, response);
			}
			else if(userValidate.getUrole_ID()==3)
			{
				System.out.println("Driver's Home");

				HttpSession session = request.getSession();
				session.setAttribute("Driver", uName);
				request.setAttribute("userName", uName);

				request.getRequestDispatcher("driver.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("status", "failed");
	            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	    		rd.forward(request, response);
	        }
		}
		catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("status", "error");
		}
	} //End of doPost()
	
	}


