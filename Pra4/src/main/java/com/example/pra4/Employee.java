package com.example.pra4;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

@WebServlet(name = "emp", value = "/emp")
public class Employee extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        try {
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            List<EmployeeEntity> employees = session.createQuery("FROM EmployeeEntity", EmployeeEntity.class).list();
            int employeeCount = employees.size();
            double maxSalary = employees.stream().mapToDouble(EmployeeEntity::getSalary).max().orElse(0);
            double minSalary = employees.stream().mapToDouble(EmployeeEntity::getSalary).min().orElse(0);
            double totalSalary = employees.stream().mapToDouble(EmployeeEntity::getSalary).sum();
            double averageSalary = totalSalary / employeeCount;
            transaction.commit();
            session.close();
            request.setAttribute("employeeCount", employeeCount);
            request.setAttribute("maxSalary", maxSalary);
            request.setAttribute("minSalary", minSalary);
            request.setAttribute("totalSalary", totalSalary);
            request.setAttribute("averageSalary", averageSalary);
            RequestDispatcher dispatcher = request.getRequestDispatcher("empinfo.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
