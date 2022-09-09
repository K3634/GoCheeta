<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
   <jsp:include page="admin.jsp" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<title>GoCheeta</title>
</head>
<body>

 <div class= "container">
   <br/>
    <br/>
 <p>${message}</p>
 <p>${deleteMessage}</p>
 <br/>
  <br/> 
  <table class="table table-hover">
     <thead>
       <tr>
        
           <th>Driver ID</th>
           <th>Driver Name</th>
           <th>Driver Address</th>
           <th>Driver Contact Number</th>
           <th>Branch Name</th>
          
       </tr>
     </thead>
      <tbody>
      <tag:forEach var="driver" items="${driverList}">
             <tr>
               
                 <td>${driver.getdID()}</td>
                 <td>${driver.getDriverName()}</td>
                 <td>${driver.getDriverAddress()}</td>
                 <td>${driver.getDriverTP()}</td>
                 <td>${driver.getBranchName()}</td>
                
                 <td>
                    <form action="deleteDriver" method="post">
                    <input type="hidden" name="action" value="delete">
                     <input type="hidden" name="dID" value="${driver.getdID()}">  
                    <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                 </td>
             </tr>
       </tag:forEach>
     </tbody>
     </table>
     </div>
</body>
</html>