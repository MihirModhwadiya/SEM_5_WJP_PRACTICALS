<%--
  Created by IntelliJ IDEA.
  User: mihir
  Date: 9/29/2023
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginServlet</title>
</head>
<body>
<h2>Login</h2>
<form action="LoginServlet" method="post">
    Username: <label>
    <input type="text" name="username"/>
</label><br>
    Password: <label>
    <input type="password" name="password"/>
</label><br>
    <input type="submit" value="Login">
</form>

</body>
</html>
