<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Student" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<% List<Student> students = (List<Student>)request.getAttribute("students"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View STudents</title>
</head>
<body>
	<h1>STudent List</h1>
	<ol>
	<c:forEach var="student" items="${students}">
    <li>
        Name: ${student.name}
        Reg: ${student.reg}
        Age: ${student.age}
        Per: ${student.per}
    </li>
</c:forEach>
	
	</ol>
	
</body>
</html>
