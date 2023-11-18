package com.example.hiberservel2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.persistence.Query;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> dataFromDatabase = fetchDataFromDatabase();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Data from Database:</h2>");
        out.println("<ul>");

        if (dataFromDatabase != null) {
            for (String data : dataFromDatabase) {
                out.println("<li>" + data + "</li>");
            }
        } else {
            out.println("<li>Error fetching data from the database.</li>");
        }

        out.println("</ul>");
        out.println("</body></html>");
    }

    protected List<String> fetchDataFromDatabase() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(secondEntity.class)
                .buildSessionFactory();

        List<String> data = null;

        try (Session session = factory.openSession()) {
            session.beginTransaction();
            String jpql = "SELECT fe.name FROM secondEntity fe";
            Query query = session.createQuery(jpql);
            data = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }

        return data;
    }
}
