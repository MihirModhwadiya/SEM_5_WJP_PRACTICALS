<%--
  Created by IntelliJ IDEA.
  User: mihir
  Date: 11/7/2023
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="jakarta.servlet.*" %>
<%@ page import="jakarta.servlet.http.*" %>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    <%
        List<String[]> records = new ArrayList<String[]>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/studentdb";
            String dbUser = "root";
            String dbPassword = "";

            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
    %>
    <tr>
        <td><%= id %></td>
        <td><%= name %></td>
        <td><%= email %>
        </td>
    </tr>
    <%
            }
            conn.close();

        } catch (Exception e) {
        }
    %>
</table>