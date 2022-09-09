<html>
<head>
<title>Admin page</title>
<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("Admin")== null) )
{
%>
<jsp:forward page="Admin.jsp"></jsp:forward>
<%} %>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
</head>
<body class="w3-light-grey">
<style>
body {
  background-image: url('img_girl.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: 100% 100%;
}
</style>
<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:8,">
  <div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
   <div class="w3-container w3-display-container w3-padding-16">
    <i onclick="w3_close()" class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
    <h3 class="w3-wide"><b>WELCOME TO ADMIN PAGE</b></h3>
  </div>
 
  <hr>
  <div class="w3-container">
    <h5>Dashboard</h5>
  </div>
  <div class="w3-bar-block">
    <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
    
    <a href="add-driver.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bullseye fa-fw"></i>Add driver Details</a>
    <a href="getDriver?action=all" class="w3-bar-item w3-button w3-padding"><i class="fa fa-eye fa-fw"></i> View driver details</a>   
    <a href="search-edit-driver.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-eye fa-fw"></i> Search / Edit driver  details</a>
    <a href="add-category.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bullseye fa-fw"></i>Add vehicle details</a>
    <a href="search-edit.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-eye fa-fw"></i> Search / Edit driver & vehicle details</a>
    <a href="getCategory?action=all" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i>View All Driver & Vehicle details</a>
    <a href="getBooking?action=all" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i>View All customer booking and total sales </a>
   
    


  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Admin Dashboard</b></h5>
  </header>


        
  </div>
  
</div>

</body>
</html>
