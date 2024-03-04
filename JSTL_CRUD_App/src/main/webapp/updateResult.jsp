<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="dbConnection.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    String firstName = request.getParameter("first_name");
    String lastName = request.getParameter("last_name");
    Long id = Long.parseLong(request.getParameter("id"));

%>

<c:set var="first_name" value="<%=firstName%>"/>
<c:set var="last_name" value="<%=lastName%>"/>
<c:set var="id" value="<%=id%>"/>

<sql:update var="rs" dataSource="${db}">
    UPDATE students SET first_name = ?, last_name = ? WHERE id = ?
    <sql:param value="${first_name}"/>
    <sql:param value="${last_name}"/>
    <sql:param value="${id}"/>
</sql:update>


<a href="./">Home</a>

</body>
</html>
