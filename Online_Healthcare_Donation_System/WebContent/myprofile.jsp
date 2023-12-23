<%@page import="controller.UserDao"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>My Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .profile-container {
            margin-top: 60px;
            padding: 15px;
            width: 50%;
            margin: 0 auto;
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .profile-label {
            font-weight: bold;
            text-align: right;
        }

        .profile-value {
            color: #007bff;
        }
    </style>
</head>
<body>

<%
    HttpSession h = request.getSession();
    String email = (String) h.getAttribute("email");
    String pass = (String) h.getAttribute("pswd");
   
    try {User u = new UserDao().getProfile(email);
  
%>


<%
String role=new UserDao().signin(email,pass);
    if (role.equals("Admin")) {
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

<div class="container profile-container">
    <h4 class="text-center mb-4">My Profile</h4>

    

    <div class="row">
        <div class="col-md-6 profile-label">
            <label for="fname">First Name:</label>
        </div>
        <div class="col-md-6">
            <p class="profile-value"><%= (u != null) ? u.getFname() : "" %></p>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 profile-label">
            <label for="lname">Last Name:</label>
        </div>
        <div class="col-md-6">
            <p class="profile-value"><%= (u != null) ? u.getLname() : "" %></p>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 profile-label">
            <label for="email">Email:</label>
        </div>
        <div class="col-md-6">
            <p class="profile-value"><%= (u != null) ? u.getEmail() : "" %></p>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 profile-label">
            <label for="mob">Mobile:</label>
        </div>
        <div class="col-md-6">
            <p class="profile-value"><%= (u != null) ? u.getMobile() : "" %></p>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 profile-label">
            <label for="gender">Gender:</label>
        </div>
        <div class="col-md-6">
            <p class="profile-value"><%= (u != null) ? u.getGender() : "" %></p>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 profile-label">
            <label for="pass">Password:</label>
        </div>
        <div class="col-md-6">
            <p class="profile-value"><%= (u != null) ? u.getPass() : "" %></p>
        </div>
    </div>

<%} 
catch(Exception e){
	e.printStackTrace();
}


%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
