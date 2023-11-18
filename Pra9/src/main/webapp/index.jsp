<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>

<h1>Grade Calculator</h1>
<form action="result.jsp" method="post">
  <input placeholder="Subject 1" type="number" id="subject1" name="subject1" required>
  <br><br>
  <input placeholder="Subject 2" type="number" id="subject2" name="subject2" required>
  <br><br>
  <input placeholder="Subject 3" type="number" id="subject3" name="subject3" required>
  <br><br>
  <input placeholder="Subject 4" type="number" id="subject4" name="subject4" required>
  <br><br>
  <input placeholder="Subject 5" type="number" id="subject5" name="subject5" required>
  <br><br>
  <input type="submit" value="Calculate Grade">
</form>

</body>
</html>