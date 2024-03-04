<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@include file="dbConnection.jsp" %>
<%@ page import="org.melashvili.jstl_crud_app.StudentsUtils" %>
<%@ page import="org.melashvili.jstl_crud_app.Student" %><%--
  Created by IntelliJ IDEA.
  User: nikoloz
  Date: 26.02.24
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    Long id = Long.parseLong(request.getParameter("id"));

    Student student = StudentsUtils.getInstance().getStudentById(id);

%>


<c:set var="id" value="<%=id%>" />
<sql:query var="rs" dataSource="${db}">
    SELECT * FROM students WHERE id = ?
    <sql:param value="${id}" />
</sql:query>

<c:forEach var="row" items="${rs.rows}" varStatus="loopIndex">
    <c:if test="${loopIndex.index == 0}">
        <form action="./updateResult.jsp?id=${row.id}" method="post">
            <label>First name:</label>
            <input type="text" name="first_name" value="${row.first_name}">
            <br>
            <label>Last name:</label>
            <input type="text" name="last_name" value="${row.last_name}">
            <br>
            <input type="submit" value="submit">
        </form>
    </c:if>
</c:forEach>


</body>
</html>
