<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Error</h1>
<h2><%= request.getAttribute("javax.servlet.error.message") %></h2>
</body>
</html>
