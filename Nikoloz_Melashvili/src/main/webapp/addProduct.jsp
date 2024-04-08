<%@ page import="com.example.build.system.midterm.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Extracting Fields</title>
</head>
<body>
<h1>Product Information</h1>

<%
    String name = request.getParameter("product_name");
    String sPrice = request.getParameter("product_price");
    String sQuantity = request.getParameter("product_quantity");
    int price = Integer.parseInt(sPrice);
    int quantity = Integer.parseInt(sQuantity);

    Product product = new Product(name, price, quantity);

    request.setAttribute("product", product);
%>
</body>
</html>
