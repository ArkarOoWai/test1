<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class = "ctn">
	
	<div class="ctn2">
	<h1>Register</h1>
	<span class="msg">${error}</span>
	<form:form action = "create" method="post" modelAttribute="bean">
	<table>
		<tr>
			<td>Name<td>
			<td>
			<form:input path="userName" />
			<td>
		<tr>
		
		<tr>
			<td>Email<td>
			<td>
			<form:input type="email" path="userEmail" />
			<td>	
		<tr>
		
		<tr>
			<td>Password<td>
			<td>
			<form:password path = "password" />
			<td>	
		<tr>
		
		<tr>
			<td>Confirm Password<td>
			<td>
			<form:password path = "conPassword" />
			<td>	
		<tr>
		
		<tr>
			<td>
			<input type= "submit" value="Register" >
			<td>	
		<tr>
		
	</table>
	</form:form>
	</div>

</div>	

	<script src="javascript/script.js"></script>
</body>
</html>