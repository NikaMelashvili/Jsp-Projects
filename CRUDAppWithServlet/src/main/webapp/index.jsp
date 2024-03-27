<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Image Database</title>
</head>
<body>
<a href="/addRow.jsp">Add profile</a>
<br>
<table>
  <thead>
  <tr>
    <td>ID</td>
    <td>First name</td>
    <td>Profile picture</td>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="info" items="${someInfoList}">
    <tr>
      <td>${info.id}</td>
      <td>${info.firstName}</td>
      <td><img src="displayImage?id=${info.id}" alt="Profile Picture"></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>