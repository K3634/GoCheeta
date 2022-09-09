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

<h2>Search a driver : </h2>

<form action="getDriver" method="get">
     <label for="dID">Driver ID</label>
     <input id="dID" name="dID" type="number" class="form-control"/> 
     <input type="hidden" name="action" value="single">
     <br/>
     <button type="submit" class="btn btn-info">Search</button>
</form>
</div>
<br/>


<div class="container">
<form action="updateDriver" method="post">

    <label for="dID">Driver ID : </label>
     <input id="dID" readonly="readonly" name="dID" type="number" class="form-control" value="${driver.getdID()}"/>
     
     
     <label for="driverName">Driver Name :</label>
     <input id="driverName" name="driverName" type="text" class="form-control" value="${driver.getDriverName()}"/> 
     
     <label for="driverAddress">Driver Address :</label>
     <input id="driverAddress" name="driverAddress" type="text" class="form-control" value="${driver.getDriverAddress()}"/> 
     
     <label for="driverTP">Driver Contact Number:</label>
     <input id="driverTP" name="driverTP" type="text" class="form-control" value="${driver.getDriverTP()}"/> 
     
     
     <label for="branchName">Branch Name:</label>
     <input id="branchName" name="branchName" type="text" class="form-control" value="${driver.getBranchName()}"/> 
     
     <br/>
     <input type="hidden" name="action" value="update">
     
     <button type="submit" class="btn btn-warning">Update Information</button>

</form>
</div>
</body>
</html>