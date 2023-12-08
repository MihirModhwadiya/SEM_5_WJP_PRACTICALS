package com.example.pra3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet(name = "student", value = "/student")
public class Student extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            List<StudentEntity> studentInfos = session.createQuery("from StudentEntity", StudentEntity.class).list();
            request.setAttribute("stdinfo", studentInfos);

//            PrintWriter out = response.getWriter();
//
//            response.setContentType("text/html");
//
//            if (studentInfos != null) {
//                for (StudentEntity student : studentInfos) {
//                    out.println(
//                            "<table>" +
//                            "<tr>" +
//                            "<td> " + student.getStudentName() + " </td>" +
//                            "</tr>" +
//                            "</table>");
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
        request.getRequestDispatcher("stdinfo.jsp").forward(request, response);
    }
}
