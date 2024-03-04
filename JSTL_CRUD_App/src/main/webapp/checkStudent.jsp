<%--
  Created by IntelliJ IDEA.
  User: nikoloz
  Date: 26.02.24
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String firstName = request.getParameter("first_name");
    String lastName = request.getParameter("last_name");
%>

<ul>
    <li>First name: <%= firstName %></li>
    <li>Last name: <%= lastName %></li>
</ul>

<a href="./saveStudent.jsp?first_name=<%=firstName%>&last_name=<%=lastName%>">save</a>

</body>
</html>
