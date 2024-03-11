<%@ page import="org.melashvili.shualedurimelashvili.Product" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
    %>


    <a href="./saveProduct.jsp?name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>">save</a>
</body>
</html>
