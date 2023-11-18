package com.example.hiberservel2;

import com.example.hiberservel2.secondEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteBook", value = "/DeleteBook")
public class DeleteBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            // Get the book ID to be deleted from the request
            int bookId = Integer.parseInt(request.getParameter("bookId"));

            // Initialize Hibernate configuration
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sf = cfg.buildSessionFactory();

            // Open a Hibernate session and begin a transaction
            Session session = sf.openSession();
            Transaction transaction = session.beginTransaction();

            // Load the book entity and delete it
            secondEntity book = session.load(secondEntity.class, bookId);
            session.delete(book);

            // Commit the transaction and close the session and session factory
            transaction.commit();
            session.close();
            sf.close();
            response.sendRedirect("books.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
