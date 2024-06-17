<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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


	<div class="container mt-1">
		<p><%=application.getAttribute("loginerror")%></p>
		<form:form action="Logindb" method="post" modelAttribute="loginbean">
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