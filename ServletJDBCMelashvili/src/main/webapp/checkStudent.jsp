<%@ page import="org.melashvili.servletappjdbc.Database" %>
<%@ page import="java.util.List" %>
<%@ page import="org.melashvili.servletappjdbc.Student" %><%--
  Created by IntelliJ IDEA.
  User: nikoloz
  Date: 26.02.24
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Check</title>
</head>
<body>

<%
    String firstName = request.getParameter("first_name");
    String lastName = request.getParameter("last_name");
    String url = "jdbc:mysql://localhost:3306/uni";
    String user = "nika";
    String pass = "thegoatlevi123";
    Database database = new Database(url, user, pass, firstName, lastName);
    database.addStudent();
%>

<a href="./index.jsp">save</a>

</body>
</html>
