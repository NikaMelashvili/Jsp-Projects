<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:setDataSource
        var="db"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3307/ug"
        user="root" password="123"
/>