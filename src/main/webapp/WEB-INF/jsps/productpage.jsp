<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Information</title>
</head>
<h2>Product Information</h2>
<body>
   <form action="save"method="post">
   
   Product ID <input type="text" name="id"> <br/>
   Product Name <input type="text" name="id"> <br/>
   Product Type <input type="text" name="id"> <br/>
   Product Type :
<select name="type">
<option value="electronics">Electronics</option>
<option value="homeappliencs">Home Appliences</option>
<option value="furnitures">Furniture</option>
<option value="clothing">Clothing</option>
</select> <br/>
  <input type="submit" value="save"> 
   
   
   
   
   </form>

</body>
</html>