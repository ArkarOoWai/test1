<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="StyleScript/course.css">
</head>
<body>
<div align="right">
<h3>Admin : ${user.userName}</h3>
<a href="../logout">logout</a>
</div>
<%-- <%@ include file="adminview.jsp" %> --%>
<%-- <jsp:include page="adminview.jsp" flush="true"></jsp:include> --%>
	<div class="ctn">
		<div class="ctn2">
		<h1>Course Edit</h1>
		${status}
		<form:form action="../update" method="post" modelAttribute = "course">
		<table>
		
		<tr>
			<td>Id</td>
			<td>
				<form:input path= "cId" value="${course.cId}"/>
			</td>
			</tr>
			<tr>
			<td>Course Name</td>
			<td>
				<form:input path= "cName" value="${course.cName}"/>
			</td>
			</tr>
			
			<tr>
			<td>Course Fees</td>
			<td>
				<form:input path= "cFees" value="${course.cFees}"/>
			</td>
			</tr>
			
			
			<tr>
			<td>Course Duration</td>
			<td>
				<form:input path= "cDuration" value="${course.cDuration}"/>
			</td>
			</tr>
			
			<tr>
			<td>Status</td>
			<td>
			Active<form:radiobutton path="status" value="${course.status}" checked="true"/><br>
			Inactive<form:radiobutton path="status" value="false"/><br>
			</td>
			</tr>
			
			<tr>
			<td>
			<input type="submit" value="Update" name="submit" class="btn btn-secondary">
			</td>
			</tr>


		</table>
		</form:form>
		</div>
	</div>
</body>
</html>