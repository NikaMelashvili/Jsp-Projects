<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1 style="margin: auto">Store Images</h1>

<div>
    <form action="/add-image" method="post" enctype="multipart/form-data">
        <label>Select an image</label>
        <input type="file" name="image">
        <input type="submit" value="submit">
    </form>
</div>
</body>
</html>
