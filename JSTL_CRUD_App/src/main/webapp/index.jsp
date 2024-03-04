<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="dbConnection.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<sql:query var="rs" dataSource="${db}">
    SELECT * FROM students
</sql:query>

<a href="./addStudent.jsp">Add student</a>

<table width="100%" border="1">
    <thead>
        <td>ID</td>
        <td>First name</td>
        <td>Last name</td>
        <td>Action</td>
        <td>Action</td>
    </thead>
    <tbody>
            <c:forEach var="student" items="${rs.rows}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.first_name}</td>
                    <td>${student.last_name}</td>
                    <td><a href="./updateStudent.jsp?id=${student.id}">Update</a></td>
                    <td><a href="./deleteStudent.jsp?id=${student.id}">Delete</a></td>
                </tr>
            </c:forEach>
    </tbody>
</table>

</body>
</html>