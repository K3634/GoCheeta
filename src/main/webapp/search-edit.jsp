<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <jsp:include page="admin.jsp"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<title>GoCheeta</title>
</head>

<body>

<div class="container">
<br/>
<p>${message}</p>

<h2>Search Vehicle : </h2>

<form action="getCategory" method="get">
     <label for="categoryID">Vehicle ID</label>
     <input id="categoryID" name="categoryID" type="number" class="form-control"/> 
     <input type="hidden" name="action" value="single">
     <br/>
     <button type="submit" class="btn btn-info">Search</button>
</form>
</div>
<br/>


<div class="container">
<form action="updateCategory" method="post">

    <label for="categoryID">Vehicle ID : </label>
     <input id="categoryID" readonly="readonly" name="categoryID" type="number" class="form-control" value="${category.getCategoryID()}"/>
     
     <label for="vehicleNo">Vehicle No : </label>
     <input id="vehicleNo" name="vehicleNo" type="text" class="form-control" value="${category.getVehicleNo()}"/> 
          
     <label for="vehicleName">Vehicle Name : </label>
     <input id="vehicleName" name="vehicleName" type="text" class="form-control" value="${category.getVehicleName()}"/> 
     
     <label for="branchName">Branch Name : </label>
     <input id="branchName" name="branchName" type="text" class="form-control" value="${category.getBranchName()}"/> 
     
     <label for="price">price : </label>
     <input id="price" name="price" type="text" class="form-control" value="${category.getPrice()}"/> 
     
     <label for="driverID">Associate Driver ID :</label>
     <input id="driverID" name="driverID" type="text" class="form-control" value="${category.getDriverID()}"/> 
     
     <label for="driverName">Associate Driver Name :</label>
     <input id="driverName" name="driverName" type="text" class="form-control" value="${category.getDriverName()}"/> 
     
     <label for="driverTP">Associate Driver Contact Number:</label>
     <input id="driverTP" name="driverTP" type="text" class="form-control" value="${category.getDriverTP()}"/> 
     
     <br/>
     <input type="hidden" name="action" value="update">
     
     <button type="submit" class="btn btn-warning">Update Information</button>

</form>
</div>
</body>
</html>