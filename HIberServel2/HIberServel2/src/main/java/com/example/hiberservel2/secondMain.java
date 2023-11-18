package com.example.hiberservel2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.hiberservel2.secondEntity;
import jakarta.servlet.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

@WebServlet(name = "secondMain" , value = "/secondMain")
public class secondMain extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookName");
        String authorName = request.getParameter("authorName");

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session =  sf.openSession();
        Transaction tra = session.beginTransaction();

        try {

            secondEntity s1 = new secondEntity();
            s1.setBookName(bookName);
            s1.setBookAuthor(authorName);


            session.save(s1);
            tra.commit();
        } catch (Exception e) {
            if (tra != null) {
                tra.rollback();
            }
            e.printStackTrace();
        } finally {

            session.close();
            sf.close();
        }
        response.sendRedirect("books.jsp");



    }
}
