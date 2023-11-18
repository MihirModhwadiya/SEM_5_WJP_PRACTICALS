package com.example.hiberservel2;

import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.example.hiberservel2.studentEntity;

import java.io.IOException;
import java.io.PrintWriter; // Import PrintWriter to write JavaScript to the response.
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet(name = "studentMain", value = "/studentMain")
public class studentMain extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentName = request.getParameter("studentName");
        String bookId = request.getParameter("bookId");

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tra = session.beginTransaction();

        Calendar cl = Calendar.getInstance();
        cl.add(Calendar.DATE, 15);
        java.sql.Date end_date = new java.sql.Date(cl.getTimeInMillis());

        Calendar cl1 = Calendar.getInstance();
        java.sql.Date start_date = new java.sql.Date(cl1.getTimeInMillis());

        List<String> data = null;
        PrintWriter out = response.getWriter();
        try {

            String sql = "SELECT sec.id FROM secondEntity sec WHERE sec.id=" + Integer.parseInt(bookId);
            Query query = session.createQuery(sql);
            data = query.getResultList();

            PrintWriter outtt = response.getWriter();
            outtt.println("<script>alert('" + data + "');</script>");
            if (!data.isEmpty()) {
                studentEntity std = new studentEntity();
                int id = Integer.parseInt(bookId);
                std.setName(studentName);
                std.setId(id);
                std.setStart_date(start_date);
                std.setEnd_date(end_date);

                session.save(std);
                tra.commit();

                PrintWriter outt = response.getWriter();
                outt.println("<script>alert('Book added successfully.');</script>");
                response.sendRedirect("studentshow.jsp");
            }else{
                response.sendRedirect("student.jsp");
            }
        } catch (Exception e) {
            // Book addition failed. Send a JavaScript alert.
            out.println("<script>alert('"+e+"');</script>");
        } finally {
            session.close();
            sf.close();
        }
    }
}
