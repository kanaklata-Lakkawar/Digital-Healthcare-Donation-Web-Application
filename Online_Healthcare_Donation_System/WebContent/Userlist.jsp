<%@page import="model.User"%>
<%@page import="controller.UserDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.html" %> 
<%@ include file="adminNav.html" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin Profile</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container" style='margin-top: 30px;'>
 <div class="container" style='padding: 15px; width: 50%; margin: 0 auto;'>
<form action="" method="get" id="searchForm">
  <input type="text" class="form-control" id="fname" name="fname" placeholder="Search By first name" value="<%= (request.getParameter("fname") != null) ? request.getParameter("fname") : "" %>">
  <br>
    <button type="submit" class="btn btn-primary">Search</button>
</form>
</div>
</div>

<%
    ArrayList<User> list;

    String fname = request.getParameter("fname");

    if (fname != null && !fname.isEmpty()) {
        list = new UserDao().getUserByFirstName(fname);
    } else {
        list = new UserDao().getAllUser();
    }
%>

<table class="table table-bordered">
    <thead>
        <tr>
            <th><input type="checkbox" id="selectAllCheckbox"> Select All</th>
            <th>Sr. No.</th>
            <th>Role</th>
            <th>Name</th>
            <th>Email</th>
            <th>Mobile.</th>
            <th>Gender</th>
            <th>Id Proof</th>
            <th>Is Confirmed?</th>
        </tr>
    </thead>
    <tbody>
        <% for (User u : list) { %>
            <tr>
                <td><input type="checkbox" class="selectCheckbox" name="selectedUsers" value="<%= u.getId() %>"></td>
                <td><%= u.getId() %></td>
                <td><%= u.getRole() %></td>
                <td><%= u.getFname() %> <%= u.getLname() %></td>
                <td><%= u.getEmail() %></td>
                <td><%= u.getMobile() %></td>
                <td><%= u.getGender() %></td>
                <td><%= u.getIdproof() %></td>
                <td><%= u.isConfirmed() ? "Confirmed" : "Not Confirmed" %></td>
            </tr>
        <% } %>
    </tbody>
</table>
<br>
<button type="button" class="btn btn-success" onclick="confirmSelected()">Confirm</button>

<script>
    // JavaScript code for handling "Select All" functionality

    // Get the "Select All" checkbox and individual checkboxes
    const selectAllCheckbox = document.getElementById('selectAllCheckbox');
    const checkboxes = document.querySelectorAll('.selectCheckbox');

    // Add an event listener to the "Select All" checkbox
    selectAllCheckbox.addEventListener('change', function () {
        checkboxes.forEach((checkbox) => {
            checkbox.checked = selectAllCheckbox.checked;
        });
    });

    function confirmSelected() {
        document.getElementById('searchForm').submit();
    }
</script>

</body>
</html>
