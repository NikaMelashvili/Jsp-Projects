        <%@ page import="org.melashvili.servletappjdbc.Student" %>
<%@ page import="org.melashvili.servletappjdbc.Database" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>


<%
    Long id = null;
    String idParam = request.getParameter("id");
    if (idParam != null && !idParam.isEmpty()) {
        id = Long.parseLong(idParam);
    }
    String url = "jdbc:mysql://localhost:3306/uni";
    String user = "nika";
    String pass = "thegoatlevi123";
    Database database = new Database(url, user, pass);
    Student student = database.getStudentById(id);
%>
<form action="./updateResult.jsp?id=<%=student.getId()%>" method="post">
    <label>First name:</label>
    <input type="text" name="first_name" value="<%=student.getFirstName()%>">
    <br>
    <label>Last name:</label>
    <input type="text" name="last_name" value="<%=student.getLastName()%>">
    <br>
    <input type="submit" value="Update">
</form>
</body>
</html>
