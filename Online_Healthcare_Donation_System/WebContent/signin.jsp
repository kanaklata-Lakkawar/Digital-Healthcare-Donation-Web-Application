<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <%@ include file="header.html" %>  
<title>Insert title here</title>
</head>
<body>
<%

String message = (String) request.getAttribute("message");
if (message != null) {
%>
   <br><div class='alert alert-danger' role='alert'><%=message %></div>
<%}
String message2 = (String) request.getAttribute("message3");
if (message2 != null) {
%>

<br><div class='alert alert-success' role='alert'><%=message2 %></div>
<%} %>
<%
String message3 = (String) request.getAttribute("message2");
if (message3 != null) {
%>

<br><div class='alert alert-success' role='alert'><%=message3 %></div>
<%} %>
<div class="container" style='margin-top: 120px;'>
   
    <div class="container" style=' padding: 15px; width: 50%; margin: 0 auto;'>
      <h4 style='text-align: center;'>Signin</h4>
  <form action="signinserv">
  
      <div class="form-group ">
      <!-- <label for="email">Email:</label> -->
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" required >
    </div>
    <div class="form-group ">
     <!--  <label for="pwd">Password:</label> -->
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd" required >
    </div>

    <button type="submit" class="btn btn-primary">Signin</button>
    
    <br><br>
<a href="signupDonar.jsp" style="display: inline-block; padding: 10px 20px; background-color: #4CAF50; color: #fff; text-decoration: none; border-radius: 5px; margin-right: 10px;">Signup as Donar</a>

  <a href="signupNGO.jsp" style="display: inline-block; padding: 10px 20px; background-color: #3498db; color: #fff; text-decoration: none; border-radius: 5px;">Signup as NGO</a>

  </form>
</div>
</div>

</body>
</html>