<%@ page import="org.melashvili.servletappjdbc.Database" %>
<%@ page import="org.melashvili.servletappjdbc.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Management System</title>
</head>
<body>

<a href="./addStudent.jsp">Add Student</a>

<table width="100%" border="1">
    <thead>
    <tr>
        <td>ID</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Action</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <%
        String url = "jdbc:mysql://localhost:3306/uni";
        String user = "nika";
        String pass = "thegoatlevi123";
        Database database = new Database(url, user, pass);
        List<Student> students = database.getAllStudents();
        for (Student student : students) {%>
    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getFirstName() %></td>
        <td><%= student.getLastName() %></td>
        <td><a href="./updateStudent.jsp?id=<%= student.getId() %>">Update</a></td>
        <td><a href="./deleteStudent.jsp?id=<%= student.getId() %>">Delete</a></td>
    </tr>
    <% } %>
    </tbody>
</table>

</body>
</html>
