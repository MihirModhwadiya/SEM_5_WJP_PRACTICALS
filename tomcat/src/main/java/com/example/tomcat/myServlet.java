package com.example.tomcat;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "myServlet", urlPatterns = {"/myServlet"})
public class myServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String status = "";
        String title = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

            String sql = "INSERT INTO register (name, email, password) VALUES(?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            int result = pst.executeUpdate();

            String slct = "SELECT * FROM test.register";
            PreparedStatement pstmt = conn.prepareStatement(slct);
            ResultSet rs = pstmt.executeQuery();

            out.println("<html><<body><table>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td></tr>");
            }
            out.println("</html></body></table>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}