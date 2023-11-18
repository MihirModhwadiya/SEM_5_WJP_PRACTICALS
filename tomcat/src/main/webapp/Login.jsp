<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 29-09-2023
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>

<div class="login-container">
    <form action="Login" method="post">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Login">
        <a href="index.jsp" class="back-button"><i class="fas fa-arrow-left"></i> Back</a>
    </form>
</div>
</body>
</html>
