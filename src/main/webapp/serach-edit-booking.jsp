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


<div class="container">
<br/>
<p>${message}</p>
<br/>
<h2>Search a vehicle type : </h2>
<br/>
<form action="getBooking" method="get">
     <label for="b_ID">Booking ID</label>
     <input id="b_ID" name="b_ID" type="number" class="form-control"/> 
     <input type="hidden"  name="action" value="single">
     <br/>
     <button type="submit" class="btn btn-info">Search</button>
</form>
</div>

<br/>


<div class="container">
<form action="getTheBookingByb_ID" method="post">

    <label for="b_ID">BookingID : </label>
     <input id="b_ID" readonly="readonly" name="b_ID" type="number" class="form-control" value="${booking.getB_ID()}"/>
     
     <label for="cName">Customer Name : </label>
     <input id="cName" readonly="readonly" name="cName" type="text" class="form-control" value="${booking.getcName()}"/> 
     
     <label for="pickUp">PickUp Location : </label>
     <input id="pickUp" readonly="readonly" name="pickUp" type="text" class="form-control" value="${booking.getPickUp()}"/> 
     
     <label for="dropUp">DropUp Location: </label>
     <input id="dropUp"  readonly="readonly"name="dropUp" type="text" class="form-control" value="${booking.getDropUp()}"/> 
     
     <label for="vCat">Vehicle Type : </label>
     <input id="vCat"  readonly="readonly"  name="vCat" type="text" class="form-control" value="${booking.getvCat()}"/> 
     
     <label for="b_date">Booking Date :</label>
     <input id="b_date"  readonly="readonly" name="b_date" type="text" class="form-control" value="${booking.getB_date()}"/> 
     
     <label for="pay">Payment Mood :</label>
     <input id="pay"   readonly="readonly" name="pay" type="text" class="form-control" value="${booking.getPay()}"/> 
    
  

</form>
</div>
</body>
</html>