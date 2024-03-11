<%--
  Created by IntelliJ IDEA.
  User: melas
  Date: 3/11/24
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="./addProduct.jsp" method="post">
    <label>Name</label>
    <input type="text" name="name">
    <label>Price</label>
    <input type="text" name="price">
    <label>Quantity</label>
    <input type="text" name="quantity">
    <input type="submit" value="submit">
</form>
</body>
</html>
