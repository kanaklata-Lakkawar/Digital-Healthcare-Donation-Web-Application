<%@page import="model.Donar"%>
<%@page import="java.util.ArrayList"%>
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
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    

  <%@ include file="donar.jsp" %> 
</head>
<body>
<%


HttpSession h=request.getSession();
String email=(String) h.getAttribute("email");
ArrayList<Donar> list = new UserDao().getUserDonationHistory(email);
%>

<table class="table table-bordered">
        <thead>
            <tr>
               
                <th>Sr. No.</th>
                <
                <th>Medicine Brand Name</th>
                <th>Medicine Generic Name</th>
                 <th>Manufacturing Date</th>
                 <th>Expiry Date</th>
                <th>Quantity</th>
                <th>Image</th>
            </tr>
        </thead>
        <tbody>
            <% for (Donar m : list) { %>
                <tr>
                    
                    <td><%= m.getDonorId() %></td>
                   
                    <td><%= m.getBrand() %></td>
                     <td><%= m.getGeneric() %></td>
                    <td><%= m.getMftDt() %></td>
                    <td><%= m.getExpDt() %></td>
                    <td><%=m.getQty() %></td>
                  <td><img src="./upload/<%=m.getImageName()%>" width="200" height="200"></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>