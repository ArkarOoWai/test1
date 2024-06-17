<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<<%-- div align="right">
<h3>User : ${user.userName}</h3>
<a href="../logout">logout</a>
</div> --%>
<jsp:include page="userview.jsp" flush="true"></jsp:include>
<form:form action="chooseCourse" modelAttribute="usercourse" method="post">
User Id<br>
<form:input path="userId" value="${user.userId}" readonly="true"/><br>

<c:forEach items="${nextCourse}" var="course"> 
${course.cName}
<form:checkbox path="userCourseList" value="${course.cId}"/>
</c:forEach>
<br> <input type="submit" value="choose">
</form:form>

</body>
</html>