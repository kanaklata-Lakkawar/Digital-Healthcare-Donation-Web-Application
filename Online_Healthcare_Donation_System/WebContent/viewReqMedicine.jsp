<%@page import="model.Medicine"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="controller.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style>
  .card-container {
    display: flex;
    flex-wrap: wrap;

  }

  .w3-card-4 {
    width: 30%; /* Adjust the width as needed */
    margin-bottom: 20px;
    text-align: center; /* Center the content */
    padding: 10px;
    box-sizing: border-box; /* Include padding and border in the element's total width and height */
  }

  .ngo-section {

    background-color: #f9a825 !important;
    height: 55px;
    width: 100%;
    display: flex;
    align-items: center; /* Center the content vertically */
    justify-content: center; /* Center the content horizontally */
  }
</style>
<title>Insert title here</title>

<%@ include file="donar.jsp" %> 
</head>
<body>
<%

HttpSession h=request.getSession();
String email=(String) h.getAttribute("email");


ArrayList<Medicine> list = new UserDao().getAllReqMed();

%>

<div class="card-container">
  <% for (Medicine m : list) { %>

  
    <div class="w3-card-4">
      <div class="ngo-section">
        <h3 ><%=m.getNgo() %></h3>
      </div>
      <h1>Quantity: <%= m.getQty() %></h1>
      <p>Brand: <%=m.getBrand() %></p>
      <p>Generic: <%=m.getGeneric() %></p>
      <p>Address: <%=m.getAdd() %></p>
      <button class="w3-button w3-block w3-red" onclick="window.location.href='sendonation.jsp?id=<%=m.getMedId() %>'">click here to Donate</button>
     

    </div>
  <% } %>
</div>

</body>
</html>