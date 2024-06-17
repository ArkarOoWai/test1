<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<<%-- div align="right">
<h3>Admin : ${user.userName}</h3>
<a href="../logout">logout</a>
</div> --%>
<jsp:include page="userview.jsp" flush="true"></jsp:include>
<h3>User Select Course</h3>
<table class="table table-striped">
    <tr>
        <td class="head">No</td>
        <td class="head">User Name</td>
        <td class="head">Course Name</td>
    </tr>
    
    <tr>
        <td class="head">1</td>
        <td class="head">${UserName}</td>
        <td class="head">
        <c:forEach items="${lstUserCourse}" var="course" varStatus="courseIndex">
                    ${course.getCourseName()}
                    <c:if test="${!courseIndex.last}">,</c:if>
                </c:forEach>
        </td>
    </tr>
    <%-- ${"lstUserCourse.getUserName()"} --%>
       
                
    
</table>
</body>
</html>