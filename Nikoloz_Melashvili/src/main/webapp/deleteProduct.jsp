<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="dbConnection.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleted Student</title>
</head>
<body>
    <%
        String id = request.getParameter("productId");
        int productId = Integer.parseInt(id);
    %>
    <c:set var="productId" value="<%=productId%>" />
    <sql:update dataSource="${db}" var="table">
        DELETE FROM products WHERE productId = ?
        <sql:param value="${productId}" />
    </sql:update>

    <a href="index.jsp">Back To Table</a>
</body>
</html>
