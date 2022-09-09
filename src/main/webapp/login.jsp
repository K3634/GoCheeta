<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@page import="com.codewithkrishanthi.model.*"%>
   <%@page import="java.util.*"%>
    <%
	Register auth = (Register) request.getSession().getAttribute("auth");
	if (auth != null) {
		response.sendRedirect("User.jsp");
	}
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.bg-image-vertical {
	position: relative;
	overflow: hidden;
	background-repeat: no-repeat;
	background-position: right center;
	background-size: auto 100%;
}

@media ( min-width : 728px) {
	.h-custom-2 {
		height: 100%;
	}
}
</style>




<title>GoCheeta | Login</title>
</head>
<body>

<br>
     <p>${message}</p>
  <br>
	<input type="hidden" id="status"value="<%= request.getAttribute("status")%>">
	
	<section class="vh-100 pt-5">
		<div class="container-fluid h-custom">
		
		
			<div class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-md-9 col-lg-6 col-xl-5">
					<img src="Images/booking.jpg" class="img-fluid" alt="login image">
				</div>

				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
					<form name="form" action="<%=request.getContextPath()%>/LoginServlet" method="post">
						<div class="d-flex align-items-center mb-3 pb-1">
							<i class="fas fa-mobile fa-2x me-3" style="color: #ff6219;"></i>
							<span class="h1 fw-bold mb-0">GoCheeta</span>
						</div>

						<h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign
							into your account</h5>
							

						<div class="alert alert-danger d-none " role="alert"
							id="loginAlert">
							<span id="loginAlertSpan"></span>
						</div>


						<!-- Email input -->
						<div class="form-outline mb-4">
							<input type="text" id="uName" name="uName" autocomplete="off"
								class="form-control form-control-lg" required placeholder="Enter yor User name" required="required" /> <label class="form-label"
								for="userName">User Name</label>
						</div>

						<!-- Password input -->
						<div class="form-outline mb-3">
							<input type="password" id="uPassword" name="uPassword"
								class="form-control form-control-lg" required placeholder="Enter password" required="required"/> <label class="form-label"
								for="password">Password</label>
						</div>

						<div class="d-flex justify-content-between align-items-center">
							<!-- Checkbox -->
							<div class="form-check mb-0">
								<input class="form-check-input me-2" type="checkbox" value="" id="checkBox" /> <label
									class="form-check-label" for="form2Example3"> Show Password </label>
							</div>
							<a href="forgetpassword.jsp" class="text-body">Forgot password?</a>
						</div>

						<div class="text-center text-lg-start mt-4 pt-2">
							<a>
								<button type="submit" class="btn btn-success btn-lg" style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
							</a>
							<p class="small fw-bold mt-2 pt-1 mb-0">
								Don't have an account? <a href="register.jsp" class="link-danger">Register</a>
							</p>
						</div>

					</form>
				</div>
			</div>
		</div>

	</section>
	<script src="jquery/jquery.min.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.cdnjs.com/ajax/libs/json2/20110223/json2.js"></script>
	<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
	<script src="jquery/jquery.min.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.cdnjs.com/ajax/libs/json2/20110223/json2.js"></script>
	<script src="vendor/jquery/jquery.min.js"></script>
<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "failed") {
			swal("Oops", "Please check your credentials again", "error");
		} else if (status == "error") {
			swal("Oops", "We are not able to log you in", "error");
		} 
	</script>

</body>
</html>