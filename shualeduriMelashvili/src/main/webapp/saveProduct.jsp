<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@include file="dbConnection.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: melas
  Date: 3/11/24
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Saved</title>
</head>
<body>

    <%
        String name = request.getParameter("name");
        String priceS = request.getParameter("price");
        String quantityS = request.getParameter("quantity");
        int price = Integer.parseInt(priceS);
        int quantity = Integer.parseInt(quantityS);
    %>

    <c:set var="name" value="<%=name%>" />
    <c:set var="price" value="<%=price%>" />
    <c:set var="quantity" value="<%=quantity%>" />
    <sql:update dataSource="${db}" var="table">
        INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)
        <sql:param value="${name}" />
        <sql:param value="${price}" />
        <sql:param value="${quantity}" />
    </sql:update>
    <a href="./index.jsp">back to the table</a>
</body>
</html>
