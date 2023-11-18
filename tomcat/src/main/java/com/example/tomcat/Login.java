package com.example.tomcat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name="Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("chintan") && password.equals("chintan")){
            out.println("Login Successfully");

//            ------------------------ Cookie() ------------------------------------

            Cookie loginCookie = new Cookie("user", username);

            loginCookie.setPath("/");
            loginCookie.setMaxAge(60 * 60); // 1 hour in seconds

            response.addCookie(loginCookie);
//            out.println(loginCookie);
//            response.getWriter().println("<h1>THis this my practice:</h1>");

//            --------------------- Session -----------------------------------

            HttpSession session = request.getSession();
            session.setAttribute("password" , password); //Set the value of session variable

//          Print the all Session variable :-
            Enumeration<String> attriName = session.getAttributeNames();
            out.println("<br><br>Session Attribute Names:<br>");
            while (attriName.hasMoreElements()) {
                String attributeName = attriName.nextElement();
                out.println("-->" + attributeName + "<br>");
            }

//            Print the value of session variable :-
            String sessionP =(String) session.getAttribute("password");
            out.println("<br><br>Session Password: " + sessionP);


//            --------------------- getParameterNames() -----------------------------

            Enumeration <String> parameter = request.getParameterNames();
            out.println("<br><br><br><br>Parameter Names:<br>");
            while (parameter.hasMoreElements()) {
                String param = parameter.nextElement();
                out.println("-->" +param + "<br>");
            }

//          ----------------- getHeaderNames() ---------------------------------

//            Enumeration<String> header = request.getHeaderNames();
//            out.println("<br><br><big>HTTP Headers:</big><br>");
//            while (header.hasMoreElements()) {
//                String headerName = header.nextElement();
//                String headerValue = request.getHeader(headerName);
//                out.println(headerName + "<b>:</b> " + headerValue + "<br>");
//            }
        } else {
            out.println("Login Failed");
        }
    }
}
