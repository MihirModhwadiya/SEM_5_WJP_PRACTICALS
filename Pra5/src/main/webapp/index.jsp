<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Login</h2>
<%--<a href="hello-servlet">hiii</a>--%>
<form action="hello-servlet" method="post">
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