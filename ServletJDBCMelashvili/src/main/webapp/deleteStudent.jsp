<%@ page import="org.melashvili.servletappjdbc.Database" %><%--
  Created by IntelliJ IDEA.
  User: nikoloz
  Date: 26.02.24
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Student</title>
</head>
<body>

<%
    Long id = Long.parseLong(request.getParameter("id"));
    String url = "jdbc:mysql://localhost:3306/uni";
    String user = "nika";
    String pass = "thegoatlevi123";
    Database database = new Database(url, user, pass);
    database.deleteStudentById(id);
%>

<a href="./">Home</a>

</body>
</html>
