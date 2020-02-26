<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
<form action="student" method="post">

Student Id: <input type="text" name="id">
<br>
FullName: <input type="text" name="name">
<br>
Address: <input type="text" name="address">
<br>
city: <input type="text" name="city">
<br>
zip: <input type="text" name="zip">
<br>
e-mail : <input type="text" name="email">
 <br>
Date Of Birth : <input type="date" name="date">
<br>
<input type="submit" value="save"> 
<input type="reset" value="Reset"> 

<a href="student?action=list">View Student List</a>
</form>

</body>
</html>