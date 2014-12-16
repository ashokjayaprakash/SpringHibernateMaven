<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
Welcome
<table>
	<tr>
		<td>Id</td>
		<td>Name</td>
		<td>Mark</td>
		<td>Subject Id</td>
		<td>Action</td>
	</tr>
<c:forEach items="${keys }" var="key">
	<tr>
		<td>${key.id }</td>
		<td>${key.name }</td>
		<td>${key.mark}</td>
		<td>${key.subjectId }</td>
		<td>
			<a href="view/${key.id}">View</a>
			<a href="delete/${key.id}">Delete</a>			
		</td>
	</tr>
</c:forEach>
	
</table>
<form:form action="data" method="post" modelAttribute="userData">
		Name
		<form:input path="name"/>	
		Mark
		<form:input path="mark"/>
		Subject Id
		<form:input path="subjectId"/>	
		<input type="submit" value="Save">			
	</form:form>

</body>
</html>