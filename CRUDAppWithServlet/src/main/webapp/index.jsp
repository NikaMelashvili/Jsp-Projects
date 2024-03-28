<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Image Database</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/addRow.jsp">Add profile</a>
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
  <c:forEach var="db" items="${someInfoList}">
    <tr>
      <td>${db.id}</td>
      <td>${db.firstName}</td>
      <td><img src="displayImage?id=${db.id}" alt="Profile Picture"></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>