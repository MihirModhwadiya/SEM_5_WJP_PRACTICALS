<%--
  Created by IntelliJ IDEA.
  User: mihir
  Date: 03/7/2023
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Second</title>
</head>
<body>

<h1>Registration Confirmation</h1>
<%
    String username = request.getParameter("username");
    String email = request.getParameter("email");
%>
<p>Thank you,<strong><%= username %> </strong>, for registering with email: <strong><%= email %></strong></p>
</body>
</html>
