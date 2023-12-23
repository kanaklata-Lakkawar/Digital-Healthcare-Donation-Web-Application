<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

    <style>
        .navbar {
            background-color: #343a40; 
        }

        .navbar-dark .navbar-nav .nav-link {
            color: #ffffff !important; 
        }

        .navbar-dark .navbar-toggler-icon {
            background-color: #ffffff; 
        }

        .navbar-right {
            margin-left: auto;
        }

        .navbar-right .nav-item {
            margin-right: 15px;
        }

        
        .navbar-dark .navbar-nav .nav-item.right-link a.nav-link {
            color: #f9a825 !important; /* Aqua color for the special links */
        }
        
        
    </style>
</head>
<body>

<%@ include file="header.html" %>
<nav class="navbar navbar-expand-sm navbar-dark">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="home.html">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="viewReqMedicine.jsp">View Requested Medicine</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="voluntarydonation.jsp">Voluntary Donations</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="donationhistory.jsp">Donations History</a>
            </li>
        </ul>

        
        <ul class="navbar-nav navbar-right">
            <li class="nav-item right-link">
                <a href="myprofile.jsp" class="nav-link">My Profile</a>
            </li>
            <li class="nav-item right-link">
                <a href="changePass.jsp" class="nav-link">Change Password</a>
            </li>
            <li class="nav-item right-link">
                <a href="index.html" class="nav-link">Logout</a>
            </li>
        </ul>
    </div>
</nav>


</body>
</html>
