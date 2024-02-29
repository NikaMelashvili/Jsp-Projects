<%--
  Created by IntelliJ IDEA.
  User: nikoloz
  Date: 26.02.24
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add student</title>
</head>
<body>
<form action="./checkStudent.jsp" method="post">
    <label>First name:</label>
    <input type="text" name="first_name">
    <br>
    <label>Last name:</label>
    <input type="text" name="last_name">
    <br>
    <input type="submit" value="submit">
</form>
</body>
</html>
