package com.example.pra14;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/NamePrinter")
public class NamePrinterPublisher extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NamePrinter namePrinter = new NamePrinter();

        String result = namePrinter.printName();

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>NamePrinter</title></head><body><h3>Response: " + result + "</h3></body></html>");

    }
}
