<%@page import="java.util.*"%>
<%@page import="com.codewithkrishanthi.model.*"%>
<%@page import="com.codewithkrishanthi.dao.*"%>
<%@page import="com.codewithkrishanthi.service.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<title>GoCheeta</title>
</head>
<body>
   <h1>Welcome to GoCheeta</h1>
   
   <br/>
   <br/>
  <%
	out.println(request.getAttribute("massage"));
  %>
  
   
   <br/>
   <div class= "container">
   <table class="table table-hover">
      <thead>
        <tr>
           <th>CategoryID</th>
           <th>VehicleName</th>
           <th>BranchName</th>
           <th>Price [LKR]</th>
           <th>DriverName</th>
        </tr>
       </thead>
        <tbody>
           <%
            
           List<Category>category=(ArrayList<Category>)request.getAttribute("categoryList");
           for(Category c : category){
        	   
        	   out.println("<tr>");
        	   out.println("<td>" + c.getCategoryID()+"</td>");
        	   out.println("<td>" + c.getVehicleName()+"</td>");
        	   out.println("<td>" + c.getBranchName()+"</td>");
        	   out.println("<td>" + c.getPrice()+"</td>");
        	   out.println("<td>" + c.getDriverName()+"</td>");
        	   out.println("</tr>");
        	   
           }          
           %>
        </tbody>
   </table>
   </div>   
</body>
</html>