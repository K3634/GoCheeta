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

 <form action="addDriver" method="post">
 
 <label for="dID">Enter driver ID</label>
    <input type="text" id="dID" name="dID" class="form-control"/>
    
    <label for="driverName">Enter driver Name</label>
    <input type="text" id="driverName" name="driverName" class="form-control"/>
     
    <label for="driverAddress">Enter driver Address</label>
    <input type="text" id="driverAddress" name="driverAddress" class="form-control"/>
    
     <label for="driverTP">Enter driver Contact Number</label>
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
    
    
    <br/>
    <button type="submit" class="btn btn-primary" >Add driver</button>
    <input type="hidden" name="action" value="add">
 </form>
</div>

</body>
</html>