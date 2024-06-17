<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
p {
	color: red;
}

#success {
	color: blue;
}
</style>
<script src="logindb.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<%--<p id="success"><%=application.getAttribute("success") %></p>--%>
	<span>${error}</span>
	<c:if test="${not empty success}">
	<span id="success">${success}</span>
	</c:if>


	<div class="container mt-1">
		<p><%=application.getAttribute("loginerror")%></p>
		<form:form action="checkUser" method="post" modelAttribute="loginbean">
			<div class="form-group">
				<label for="email">Email</label><br>
				<form:input type="email" path="userEmail" id="email"
					placeholder="Enter emial"/>

			</div>
			<div class="form-group">
				<label for="password">Password</label><br>
				<form:password path="password" id="password"
					placeholder="Password"/>
			</div>
			<input type="submit" value="login">
			</form:form>
			<a href="register1.jsp">Create account</a>
	</div>
</body>
</html>