<%--
  Created by IntelliJ IDEA.
  User: melas
  Date: 3/27/24
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="new-servlet" method="post" enctype="multipart/form-data">
  <input type="text" name="first_name">
  <br>
  <input type="file" name="image">
  <input type="submit" value="Upload Image">
</form>
<br>
<br>
<a href="./index.jsp">Back home</a>
</body>
</html>
