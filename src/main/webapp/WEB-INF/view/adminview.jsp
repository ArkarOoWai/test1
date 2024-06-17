<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="right">
<h3>Admin : ${user.userName}</h3>
<a href="../logout">logout</a>
</div>
<h3>Admin View</h3>

<a href="showall">Show All Course</a>
<a href="createcourse">Add Course</a>
</body>
</html>