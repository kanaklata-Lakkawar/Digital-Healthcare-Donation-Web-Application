<%@page import="model.User"%>
<%@page import="controller.UserDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.html" %> 
<%@ include file="adminNav.html" %> 

<%
    
    ArrayList<User> list = new UserDao().getAllNgoUser();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin Profile</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


    <table class="table table-bordered">
        <thead>
            <tr>
                
                <th>Sr. No.</th>
                <th>NGO Name</th>
                <th>Email</th>
                <th>Mobile.</th>
                 <th>Id Proof</th>
                 <th>Gender</th>
                
            </tr>
        </thead>
        <tbody>
            <% for (User u : list) { %>
                <tr>
                    
                    <td><%= u.getId() %></td>
                    <td><%= u.getNgo() %></td>
                    <td><%= u.getEmail() %></td>
                     <td><%= u.getMobile() %></td>
                    <td><%= u.getIdproof() %></td>
                    <td><%= u.getGender() %></td>
                    
                    
                </tr>
            <% } %>
        </tbody>
    </table>
    <br>
   

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
        document.getElementById('confirmForm').submit();
    }
</script>

</body>
</html>
