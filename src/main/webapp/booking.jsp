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


<br/>
<div class="container">
<h1>Booking your choice vehicle </h1>
<p>${message}</p>
<br/>
 <form action="addBooking" method="post">
    <label for="cName">Customer Name</label>
    <input type="text" id="cName" name="cName" placeholder="Enter Customer Name"class="form-control"/>
    
    
    <label for="pickUp">Pick Up Location</label>
    <input type="text" id="pickUp" name="pickUp" placeholder="Enter Pick Up Location"class="form-control"/>
    
     <label for="dropUp">Drop Location</label>
    <input type="text" id="dropUp" name="dropUp"placeholder="Enter Drop Location" class="form-control"/>
    
     <label for="b_date">Booking Date</label>
    <input type="date" id="b_date" id="b_date" name="b_date" placeholder="Enter Drop Location" class="form-control"/>
    
    <label for="vCat">Choose Vehicle</label>
   	<select name="vCat" class="form-select" aria-label=".form-select-lg example" required="required">
    <option value="vCat">Select Vehicle Type</option>
									<option>Van</option>
									<option>Car</option>
									<option>Mini Cooper</option>
									<option>Taxi</option>
									
	</select>
    
    <label for="pay">Payment[LRK]</label>
    <input type="number" id="pay" name="pay" placeholder="Cash on delivery" class="form-control"/>
       
       
      <br/>
      <br/>    


                <div class="form-group form-button">
					 <button type="submit" name="signup" id="signup" class="btn btn-success btn-lg" value="Register"/>Booking Now</button>
				</div>
					<input type="hidden" name="action" value="add" class="btn btn-success btn-lg"/>
							               
    </form>
</div>

</body>
</html>