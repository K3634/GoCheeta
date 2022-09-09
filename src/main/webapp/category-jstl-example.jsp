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
           <th>VehicleID</th>
           <th>Vehicle Number</th>
           <th>Vehicle Name</th>
           <th>Associate Driver ID</th>
           <th>Associate Driver Name</th>
           <th>Associate Driver Contact Number</th>
           <th>Branch Name</th>
           <th>Price [LKR]</th>
       </tr>
     </thead>
      <tbody>
      <tag:forEach var="category" items="${categoryList}">
             <tr>
                 <td>${category.getCategoryID()}</td>
                 <td>${category.getVehicleNo()}</td>
                 <td>${category.getVehicleName()}</td>
                 <td>${category.getDriverID()}</td>
                 <td>${category.getDriverName()}</td>
                 <td>${category.getDriverTP()}</td>
                 <td>${category.getBranchName()}</td>
                 <td>${category.getPrice()}</td>
                 <td>
                    <form action="deleteCategory" method="post">
                    <input type="hidden" name="action" value="delete">
                     <input type="hidden" name="categoryID" value="${category.getCategoryID()}">  
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