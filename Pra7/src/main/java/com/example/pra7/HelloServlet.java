package com.example.pra7;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        Cookie colorCookie = new Cookie("pass", pass);
        response.addCookie(colorCookie);

        HttpSession session = request.getSession(true);
        session.setAttribute("name", name);

        response.setContentType("text/html");
        response.getWriter().println("Name: " + name);
        response.getWriter().println("<br>Password: " + pass);
        response.getWriter().println("<br>Session ID: " + session.getId());
    }
}