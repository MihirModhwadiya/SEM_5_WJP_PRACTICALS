package com.example.hiberservlet;

import java.io.*;
import java.util.List;

import jakarta.persistence.Query;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    protected List<String> fetchDataFromDatabase() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(FirstHibernateEntity.class)
                .buildSessionFactory();

        try (Session session = factory.openSession()) {
            String jpql = "SELECT fe.Name FROM FirstHibernateEntity fe";
            Query query = session.createQuery(jpql);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> dataFromDatabase = fetchDataFromDatabase();
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(FirstHibernateEntity.class)
                .buildSessionFactory();

        Session session = factory.openSession();

//        try {
//            Scanner sc = new Scanner(System.in);
//            while (true) {
//                System.out.print("Enter your choice: ");
//                int ch = sc.nextInt();
//
//                switch (ch) {
//                    case 1:
//                        session.getTransaction().begin();
//                        FirstHibernateEntity first = new FirstHibernateEntity();
//
//                        System.out.print("Enter name: ");
//                        sc.nextLine();
//                        String name_to_insert = sc.nextLine();
//
//                        first.setName(name_to_insert);
//                        session.persist(first);
//
//                        session.getTransaction().commit();
//                        break;
//
//                    case 2:
//                        FirstHibernateEntity fr = new FirstHibernateEntity();
//                        String jpql = "SELECT fe.Name FROM FirstHibernateEntity fe WHERE fe.Id=1";
//                        Query query = session.createQuery(jpql);
//                        List<Object[]> results = query.getResultList();
//
//                        out.println("<h2>Database Query Results:</h2>");
//                        out.println("<table border='1'>");
//                        out.println("<tr><th>ID</th><th>Name</th></tr>");
//
//                        for (Object[] result : results) {
//                            String name = (String) result[1];
//                            out.println("<tr><td>" + name + "</td></tr>");
//                        }
//
//                        out.println("</table>");
//
////                        System.out.println("------------------------");
////                        System.out.println("| id | name |");
////
////                        for (Object[] result : results) {
////                            int id = (int) result[0];
////                            String name = (String) result[1];
////                            System.out.printf("| %d | %s |\n", id, name);
////                        }
////                        System.out.println("------------------------");
//                        break;
//
//                    default:
//                        System.out.println("Error");
//                }
//                System.out.print("Want to continue (y/n): ");
//                sc.nextLine();
//                String choice = sc.nextLine();
//                if (choice.equalsIgnoreCase("n"))
//                    break;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }

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

    public void destroy() {
    }
}