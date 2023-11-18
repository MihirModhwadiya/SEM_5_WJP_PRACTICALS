package com.example.hiberservel2;

// UpdateBookServlet.java
import com.example.hiberservel2.secondEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateBook", value = "/UpdateBook")
public class UpdateBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            String bookName = request.getParameter("bookName");
            String authorName = request.getParameter("authorName");

            // Initialize Hibernate configuration
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sf = cfg.buildSessionFactory();

            // Open a Hibernate session and begin a transaction
            Session session = sf.openSession();
            Transaction transaction = session.beginTransaction();

            // Retrieve the book entity and update its values
            secondEntity book = session.load(secondEntity.class, bookId);
            book.setBookName(bookName);
            book.setBookAuthor(authorName);

            // Save the changes to the database
            session.update(book);

            // Commit the transaction and close the session and session factory
            transaction.commit();
            session.close();
            sf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Redirect back to the "books.jsp" after the update
        response.sendRedirect("books.jsp");
    }
}
