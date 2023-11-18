<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<form action="hello-servlet" method="post">
  <label for="name">Enter your name:</label>
  <input type="text" id="name" name="name" required>
  <br>
  <label for="pass">Enter your password</label>
  <input type="password" id="pass" name="pass">
  <br>
  <input type="submit" value="Submit">
</form>
</body>
</html>