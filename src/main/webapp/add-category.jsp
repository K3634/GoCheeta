<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <jsp:include page="admin.jsp" />  
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
<br/>

 <form action="addCategory" method="post">
 
    <label for="">Enter vehicle Number</label>
    <input type="text" id="vehicleNo" name="vehicleNo" class="form-control"/>
    
    <label for="vehicleName">Enter New vehicle Type</label>
    	<select name="vehicleName" class="form-select" aria-label=".form-select-lg example" required="required">
    <option value="vehicleName">Select Vehicle Type</option>
									<option>Van</option>
									<option>Car</option>
									<option>Cab</option>
									<option>Taxi</option>
									
	</select>
    
   <label for="driverID">Associate Driver ID</label>
    <input type="text" id="driverID" name="driverID" class="form-control"/>
    
     <label for="driverName">Associate Driver Name</label>
    <input type="text" id="driverName" name="driverName" class="form-control"/>
    
     <label for="driverTP">Associate Driver contact number</label>
    <input type="text" id="driverTP" name="driverTP" class="form-control"/>
    
    <label for="branchName">Associate branch Name</label>
    <select name="branchName" class="form-select" aria-label=".form-select-lg example" required="required">
								<option value="branchName">Select Branch</option>
							        <option>Galle</option>
							        <option>Kandy</option>
							        <option>Nugegoda</option>
							        <option>Gampaha</option>
							        <option>Kurunagala</option>
									<option>Jaffna</option>				
								</select>
    
    
    <label for="price">Enter Vehicle price</label>
    <input type="number" id="price" name="price" class="form-control"/>
    
    <input type="hidden" name="action" value="add"/>
    <br/>
    
    <button type="submit" class="btn btn-primary">Add Details</button>
 </form>
</div>

</body>
</html>