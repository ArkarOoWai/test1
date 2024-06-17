<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="StyleScript/showjsp.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<%-- <div align="right">
<h3>Admin : ${user.userName}</h3>
<a href="../logout">logout</a>
</div> --%>
<%-- <%@ include file="adminview.jsp" %> --%>
<jsp:include page="adminview.jsp" flush="true"></jsp:include>
<%-- <jsp:include page="userview.jsp" flush="true"></jsp:include> --%>
		<div style="text-align: center; margin-bottom:15px;">${msg}</div>
		
		<table class="table table-striped">
			<tr>
				<td class="head">No</td>
				<td class="head">Course Name</td>
				<td class="head">Course Fees</td>
				<td class="head">Course Duration</td>
				<td>Action</td>
			</tr>
			
			<c:forEach items="${nextCourse}" var="course" varStatus="index">
			<tr>
				<td>${index.count}</td>
				<td>${course.getcName()}</td>
				<td>${course.getcFees()} </td>
				<td>${course.getcDuration()}</td>
				<td>
				<a href="edit/${course.cId}">Edit</a>
				<a href="">Delete</a>
				</td>
			</tr>
			</c:forEach>
		
		</table>
</body>
</html>