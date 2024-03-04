<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="dbConnection.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: nikoloz
  Date: 26.02.24
  Time: 10:51
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

%>

<c:set var="id" value="<%=id%>"/>

<sql:update dataSource="${db}">
    DELETE FROM students WHERE id = ?
    <sql:param value="${id}"/>
</sql:update>

<a href="./">Home</a>

</body>
</html>
