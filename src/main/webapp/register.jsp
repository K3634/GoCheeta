<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Register</title>

<!-- Font Icon -->
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css">
</head>

</head>
<body>

<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">
  <br>
     <p>${message}</p>
  <br>
	<ul class="nav nav-tabs">
		<li class="nav-item">
		  <a class="nav-link active"aria-current="page" href="#">Register Form</a>
		
		<li class="nav-item">
		   <a class="nav-link" href="login.jsp">Logout</a>
		</li>
		
	</ul>

<br>
<div class="container">
  <br/>
<p>${message}</p>
<br/>
     <form method="post" action="addCustomer"  >
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name">Your Name</i></label> 
									<input type="text" name="uName" id="uName" placeholder="Your Name" required="required" class="form-control"/>
							</div>
							<div class="form-group">
								<label for="address"><i class="zmdi zmdi-home">Address</i></label> 
								<input type="text" id="address" name="address" placeholder="Address" required="required" class="form-control"/>
							</div>
							
							<div class="form-group">
								<label for="contactNo"><i class="zmdi zmdi-phone">Contact Number</i></label> 
								<input type="number" id="contactNo" name="contactNo" placeholder="Contact Number" class="form-control" required="required"/>
							</div>
							
							
							 <div class="form-group">
								<label for="branchName"><i class="zmdi zmdi-home">Branch Name</i></label>
								
							
							
							<select name="branchName" class="form-select" aria-label=".form-select-lg example" required="required">
								<option value="branchName">Select Branch</option>
							        <option>Galle</option>
							        <option>Kandy</option>
							        <option>Nugegoda</option>
							        <option>Gampaha</option>
							        <option>Kurunagala</option>
									<option>Jaffna</option>				
								</select>
							</div>
							
							<div class="form-group">
								<label for="uPassword"><i class="zmdi zmdi-lock">Password</i></label> 
								<input type="text" id="uPassword" name="uPassword" placeholder="Password" class="form-control"required="required" />
							</div>
							
						
							
							<div class="form-group">
								<label for="urole_ID"><i class="zmdi zmdi-lock">urole_ID</i></label> 
								
								<select name="urole_ID" class="form-select" aria-label=".form-select-lg example" required="required">
								<option value="urole_ID">Select Urole_ID</option>
									<option>1</option>
									<option>2</option>
									<option>3</option>
								</select>
							</div>
							
			                <br>
							<div class="form-group form-button">
								<button type="submit" name="signup" id="signup" class="btn btn-success btn-lg" value="Register"/>Register Now</button>
							</div>
							 <input type="hidden" name="action" value="add" class="btn btn-success btn-lg"/>
							
							 <br/>               
                           <br>
	</form>
</div>
<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "success") {
			swal("Congrats", "Account created successfully", "success");
		} else if (status == "error") {
			swal("Oops", "The username has already been taken", "error");
		} else if (status == "failed") {
			swal("Oops", "Registration failed", "error");
		}
	</script>

</body>
</html>