<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="dbConnection.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Show all products</title>
</head>
<body>
<sql:query  var="pr" dataSource="${db}">
    SELECT * FROM products;
</sql:query>
<a href="checkProduct.jsp">Add product</a>
<table>
    <thead>
        <td>Product ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Action</td>
    </thead>
    <tbody>
    <c:forEach var="product" items="${pr.rows}">
        <tr>
            <td>${product.productId}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td><a href="./deleteProduct.jsp?productId=${product.productId}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>