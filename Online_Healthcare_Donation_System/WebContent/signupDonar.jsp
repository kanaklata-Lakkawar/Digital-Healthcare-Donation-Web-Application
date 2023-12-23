
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
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
<%@ include file="header.html" %>  
</head>

<body>



<div class="container" style='margin-top: 60px;'>
     
    <div class="container" style='padding: 15px; width: 50%; margin: 0 auto;'>
  <h4 style='text-align: center;'>Signup as Donar</h4>
  <form action="signupserv">
  
     <!-- <div class="form-group ">
      <select class="form-select" id="role" name="rolelist">
      <option disabled selected>Select Role</option>
      <option value="Admin">Admin</option>
      <option value="Staff">Staff</option>
      <option value="Student">Student</option>  
    </select>
      </div> -->
    
    <div class="form-group ">
    <!-- <label for="fname">Name:</label> -->  
      <input type="fname" class="form-control" id="fname" placeholder="Enter First Name" name="fname" required >
    </div>
    
    <div class="form-group ">
    <!--   <label for="lname">Name:</label> -->
      <input type="lname" class="form-control" id="lname" placeholder="Enter Last Name" name="lname" required >
    </div>
     
    <div class="form-group ">
    <!--   <label for="lname">Name:</label> -->
  
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" required >
    </div>
    
     
    <div class="form-group ">
    <!--   <label for="lname">Name:</label> -->
     
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd" required >
    </div>

<div class="form-group ">
<!--   <label for="lname">Name:</label> -->
  
      <input type="mob" class="form-control" id="mob" placeholder="Enter mobile no." name="mob" required >
    </div>
    
    <div class="form-group ">
       <select class="form-select" id="role" name="gender" required >
       <option disabled selected>Select gender</option>
      <option value="male">Male</option>
      <option value="female">Female</option>      
    </select>
      </div>
      
      <div class="form-group ">
      <select class="form-select" id="role" name="idproof" required >
      <option disabled selected>Select ID Proof</option>
  
      <option value="Aadhar Card">Aadhar Card</option>
      <option value="PAN Card">PAN Card</option>  
    </select>
      </div>
      
    <input type="hidden" name="role" value="Donar" required >
    <button type="submit" class="btn btn-primary">Signup</button>
  </form>
</div>

</div>
</body>

</html>