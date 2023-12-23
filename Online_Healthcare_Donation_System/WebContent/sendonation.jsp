<%@page import="model.Medicine"%>
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
 
  <%@ include file="ngo.jsp" %> 
</head>
<body>
<%

HttpSession h=request.getSession();
String email=(String) h.getAttribute("email");
int id= Integer.parseInt(request.getParameter("id"));
System.out.print("id "+id);
Medicine m = new UserDao().getDaonationDetail(id);

%>

<%

String message = (String) request.getAttribute("message5");
if (message != null) {
%>
   <br><div class='alert alert-success' role='alert'><%=message %></div>
<%}
%>
<div class="container" style='margin-top: 60px;'>
     
    <div class="container" style='padding: 15px; width: 50%; margin: 0 auto;'>
  <h4 style='text-align: center;'>Requested Medicine By NGO</h4>
  <form action="sendonationserv">
  
    
    
      
       <div class="form-group ">
   <!-- <label for="idproof">Id Proof :</label> -->
      <input type="ngo" class="form-control" id="ngo"  name="ngo" value=<%=m.getNgo() %> readonly >
    </div>
      <div class="form-group ">
    <!-- <label for="fname">Name:</label> -->  
      <input type="fname" class="form-control" id="fname"  name="brand" value=<%=m.getBrand() %> readonly >
    </div>
    
    <div class="form-group ">
    <!--   <label for="lname">Name:</label> -->
      <input type="lname" class="form-control" id="lname"  name="generic" value=<%=m.getGeneric() %> readonly >
    </div>
     
    <div class="form-group ">
    <!--   <label for="lname">Name:</label> -->
  
      <input type="text" class="form-control" id="email"  name="qty" value=<%=m.getQty() %> readonly >
    </div>
    
     
    
<div class="form-group ">
<!--   <label for="lname">Name:</label> -->
  
      <input type="mob" class="form-control" id="mob" name="add" value=<%=m.getAdd() %> readonly >
    </div>
     <div class="form-group ">
    <!--   <label for="lname">Name:</label> -->
  
      <input type="text" class="form-control" id="email"  placeholder="Enter Sender's name" name="name"   >
    </div>
    
     <div class="form-group ">
    <!--   <label for="lname">Name:</label> -->
  
      <input type="text" class="form-control" id="email" placeholder="Enter Sender's mobile no." name="mob"  >
    </div>
    <input type="hidden" class="form-control" id="email"  name="id" value=<%= m.getMedId() %>  >
    <button type="submit" class="btn btn-primary">Send</button>
  </form>
</div>
</div>
</body>
</html>