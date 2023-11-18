<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: mihir
  Date: 11/7/2023
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>insertRecord</title>
</head>
<body>
<%
    PrintWriter outt = null;
    try {

        outt = response.getWriter();

        Class.forName("com.mysql.jdbc.Driver");
        String dbUrl = "jdbc:mysql://localhost:3306/studentdb";
        String dbUser = "root";
        String dbPassword = "";

        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.executeUpdate();
        conn.close();
        response.sendRedirect("display.jsp");
    } catch (Exception e) {
        outt.println(e);
    }
%>
</body>
</html>
