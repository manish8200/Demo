<%@page import="javax.persistence.metamodel.SetAttribute"%>

	<%@page
	import="com.demo.service.StudentServiceimpl,com.demo.domain.*,java.util.*"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	


<!DOCTYPE html>
<html>
<head>
<body>
	<a href="student?action=insert">Add Contact</a>
	
	<h2>Student List</h2>

	<table border="1" width="500" align="center">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>City</th>
			<th>Zip</th>
			<th>email</th>
			<th>DateOfBirth</th> 
		</tr>

		  <c:forEach items="${list}" var="u"> 
		 
		<% List<Student> list = (List<Student>) request.getAttribute("list");
		for(Student s : list)
		{%>
		
			<tr>
				<td><%=s.getStdId()%></td>
				<td><%=s.getName()%></td>
				<td><%=s.getAddress()%></td>
				<td><%=s.getCity()%></td>
				<td><%=s.getZip()%></td>
				<td><%=s.getEmail()%></td>
				<td><%=s.getDob() %></td>

				<td><a href="student?action=edit&id=<%=s.getStdId() %>">Edit</a></td>
				<td><a href="student?action=delete&id=<%=s.getStdId() %>">Delete</a></td>
<%} %>
			</tr>

		 </c:forEach> 

	</table>


</head>
</body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        