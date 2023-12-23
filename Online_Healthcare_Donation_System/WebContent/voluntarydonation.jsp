<%@page import="java.util.LinkedHashSet"%>
<%@page import="model.User"%>
<%@page import="controller.UserDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
 
  <%@ include file="donar.jsp" %> 
</head>
<body>
<%

HttpSession h4=request.getSession();
String email=(String) h4.getAttribute("email");


LinkedHashSet<User> list = new UserDao().getNgolist();

%>



<div class="container" style='margin-top: 60px;'>
     
    <div class="container" style='padding: 15px; width: 50%; margin: 0 auto;'>
  <h4 style='text-align: center;'>Donate Medicine</h4>
  <form action="voluntarydonationserv">
  
       <div class="form-group ">
   <!-- <label for="idproof">Id Proof :</label> -->
   <div class='form-group'>
  
   <select name="ngo" class="form-control">
   <option value="" disabled selected>Choose an NGO</option>
   <%for (User u : list) { %>
      <option value="<%=u.getNgo() %>"><%=u.getNgo() %></option>
   <% } %>
</select>
   
   </div>
    </div>
      <div class="form-group ">
    <!-- <label for="fname">Name:</label> -->  
      <input type="fname" class="form-control" id="fname"  placeholder="Enter Brand name" name="brand" required >
    </div>
    
    <div class="form-group ">
    <!--   <label for="lname">Name:</label> -->
      <input type="lname" class="form-control" id="lname"  placeholder="Enter Generic" name="generic" required >
    </div>
     
    <div class="form-group ">
    <!--   <label for="lname">Name:</label> -->
  
      <input type="text" class="form-control" id="email"  placeholder="Enter Quantity" name="qty" required >
    </div>
    
   <div class='form-group'>
	<input type='date' class='form-control' id='startDt' placeholder="Enter Manufacturing Date" name='mfdDt' required >
	</div>
	<div class='form-group'>
	  <input type='date' class='form-control' id='EndDt' placeholder="Enter Expiry Date" name='expDt' required >
	  </div>
   
    <button type="submit" class="btn btn-primary">Send</button>
  </form>
</div>
</div>
</body>
</html>