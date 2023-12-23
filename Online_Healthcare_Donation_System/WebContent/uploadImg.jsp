<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<%@ include file="donar.jsp" %> 
<div class="container" style='margin-top: 60px;'>
     
    <div class="container" style='padding: 15px; width: 50%; margin: 0 auto;'>
  <h4 style='text-align: center;'>Upload Image</h4>
        <form action="imgupload" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="file">Select File:</label>
             <input type="file" class="form-control-file" name="image"  accept="image/*">
               
                
            </div>
            <input type="submit" class="btn btn-primary" value="Upload" />
           
        </form>
        
        
</div>
</div>
</body>
</html>