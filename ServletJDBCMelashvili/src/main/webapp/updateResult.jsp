<%@ page import="org.melashvili.servletappjdbc.Student" %>
<%@ page import="org.melashvili.servletappjdbc.Database" %><%--
  Created by IntelliJ IDEA.
  User: melas
  Date: 2/29/24
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Updated results</title>
</head>
<body>
<%
    String firstName = request.getParameter("first_name");
    String lastName = request.getParameter("last_name");
    Long id = Long.parseLong(request.getParameter("id"));
    String url = "jdbc:mysql://localhost:3306/uni";
    String user = "nika";
    String pass = "thegoatlevi123";
    Database database = new Database(url, user, pass);
    Student student = database.getStudentById(id);
    System.out.println(student.getFirstName());
    student.setFirstName(firstName);
    student.setLastName(lastName);
    database.updateStudent(student);
    System.out.println(student.getFirstName());
%>

<a href="index.jsp">Done</a>
</body>
</html>
