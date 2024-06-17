<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
			
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Duration</th>
			<th>Fees</th>
		</tr>
		
		<c:forEach items="${lstCourse}" var="course" varStatus="index">
		<tr>
			<td>${index.count}</td>
			<td>${course.getcName()}</td>
			<td>${course.getcDuration()}</td>
			<td>${course.getcFees()}</td>
		</tr>
	</c:forEach>
	
	</table>
</body>
</html>