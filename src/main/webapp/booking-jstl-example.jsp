<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.*"%>
<%@page import="com.codewithkrishanthi.model.*"%>
<%@page import="com.codewithkrishanthi.dao.*"%>
<%@page import="com.codewithkrishanthi.service.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*"%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<title>GoCheeta</title>
</head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #04AA6D;
}
</style>
<body>
<ul>
  <li><a href="#home">All Customer Booking View</a></li>
   <li><a href="booking.jsp">Back</a></li>
    <li><a href="driver.jsp">Back drver page</a></li>
  <li><a href="admin.jsp">Logout</a></li>
 
</ul>
 
   <div class= "container">
 <h1>All customer and booking details </h1>
 <br/>
 <p>${message}</p>
 <p>${deleteMessage}</p>
 <br/>
  <table class="table table-hover">
     <thead>
       <tr>
           <th>Booking ID</th>
           <th>Customer Name</th>
           <th>PickUp Location</th>
           <th>DropUp Location</th>
           <th>Vehicle Name</th>
           <th>booking Date</th>
           <th>payment[LRK]</th>
           <th>Total Sale[LRK]</th>
           
           
           
       </tr>
     </thead>
      <tbody>
      <tag:forEach var="booking" items="${bookingList}">
             <tr>
                 <td>${booking.getB_ID()}</td>
                 <td>${booking.getcName()}</td>
                 <td>${booking.getPickUp()}</td>
                 <td>${booking.getDropUp()}</td>
                 <td>${booking.getvCat()}</td>
                 <td>${booking.getB_date()}</td>
                 <td>${booking.getPay()}</td>
                 <td>                                            <%
try{
	DbConnector connector = new DbConnectorImplMySql();
	Connection connection = connector.getConnection();
	String query = "select SUM(pay) from booking";
	PreparedStatement ps = connection.prepareStatement(query);
	ResultSet rs = ps.executeQuery();
	if(rs.next()){
		
	%>
                                            <%=rs.getInt("SUM(pay)") %>
                                            <%}
	
	
}
catch(Exception e){
	e.printStackTrace();
	
}
%>

</td>
                <td>
                    <form action="deleteBooking" method="post">
                    <input type="hidden" name="action" value="delete">
                     <input type="hidden" name="b_ID" value="${booking.getB_ID()}">  
                    <button type="submit" class="btn btn-danger">Cancel booking</button>
                    </form>
                                    
                    
               </td>
             </tr>
       </tag:forEach>
     </tbody>
     </table>
     </div>
</body>
</html>