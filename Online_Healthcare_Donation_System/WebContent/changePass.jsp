
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
  <style>
    body {
      background-image: url('pict1.jpg');
      background-size: cover;
      background-repeat: no-repeat;
    }
  </style>
</head>
<%

    HttpSession h = request.getSession();
    String email = (String) h.getAttribute("email");
    String pass = (String) h.getAttribute("pswd");
    out.print("Welcome " + email);
   
   
%>

<%
String role=new UserDao().signin(email,pass);
    if ("admin@gmail.com".equals(email)) {
%>
    <%@ include file="header.html" %>
    <%@ include file="adminNav.html" %>
<%

    } 

else if (role.equals("Donar")){
	%>
	 <%@ include file="donar.jsp" %>
<%}
    else {
%>

<%@ include file="ngo.jsp" %>
<%
    }
%>
<%

String message = (String) request.getAttribute("message1");
if (message != null) {%>
   <br><div class='alert alert-success' role='alert'>" + message + "</div>"
<%}

%>
<div class="container" style="margin-top: 120px;">
  <div class="container" style="padding: 15px; width: 50%; margin: 0 auto;">
    <h4 style="text-align: center;">Change Password</h4>
    <form action="changePassword" onsubmit="return validatePassword();">
      <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="text" class="form-control" id="pwd" name="pswd" value="<%=pass%>" readonly>
      </div>
      <div class="form-group">
        <label for="newpass">New Password:</label>
        <input type="password" class="form-control" id="newpass" name="newpass" placeholder="Enter new Password" required>
      </div>
      <div class="form-group">
        <label for="reenterpass">Re-enter New Password:</label>
        <input type="password" class="form-control" id="reenterpass" name="reenterpass" placeholder="Re-enter new Password" required>
      </div>
      <span id="password-error" style="color: red;"></span>
      <button type="submit" class="btn btn-primary">Update Password</button>
    </form>
  </div>
</div>

<script>
  function validatePassword() {
    var newPassword = document.getElementById('newpass').value;
    var reenteredPassword = document.getElementById('reenterpass').value;
    var errorSpan = document.getElementById('password-error');
    if (newPassword !== reenteredPassword) {
      errorSpan.textContent = 'Passwords do not match. Please re-enter the same password.';
      return false;
    }
    errorSpan.textContent = '';
    return true;
  }
</script>
</html>