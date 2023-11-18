<%--
  Created by IntelliJ IDEA.
  User: mihir
  Date: 11/7/2023
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>

<form action="updateRecord.jsp" method="post">
    ID to update: <input type="text" name="id" required><br>
    New Name: <input type="text" name="name" required><br>
    New Email: <input type="text" name="email" required><br>
    <input type="submit" value="Update">
</form>

</body>
</html>
