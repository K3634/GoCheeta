<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <jsp:include page="customer.jsp" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<title>GoCheeta</title>
</head>
<body>


<br/>
<div class="container">
<h1>leave a feedback </h1>
<br/>
<p>${message}</p>
<br/>
 <form action="FeedbackServlet" method="post">
 <label for="b_ID">Enter Booking ID</label>
    <input type="text" id="b_ID" name="b_ID" class="form-control"/>
    
    <label for="cName">Enter Customer Name</label>
    <input type="text" id="cName" name="cName" class="form-control"/>
    
    <label for="des">Enter Feedback</label>
    <input type="text" id="des" name="des" class="form-control"/>
   
    <input type="hidden" name="action" value="add"/>
    <br/>
    
    <button type="submit" class="btn btn-primary">leave a feedback </button>
 </form>
</div>

</body>
</html>