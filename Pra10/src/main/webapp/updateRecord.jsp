<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: mihir
  Date: 11/7/2023
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateRecord</title>
</head>
<body>
<%
    try {
        Class.forName("com.mysql.jdbc.Driver");
        String dbUrl = "jdbc:mysql://localhost:3306/studentdb";
        String dbUser = "root";
        String dbPassword = "";

        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String sql = "UPDATE students SET name=?, email=? WHERE id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setInt(3, id);
        pstmt.executeUpdate();
        conn.close();
        response.sendRedirect("display.jsp");
    }catch (Exception e){
%>
    <h1>e</h1>
<%
    }
%>
</body>
</html>
