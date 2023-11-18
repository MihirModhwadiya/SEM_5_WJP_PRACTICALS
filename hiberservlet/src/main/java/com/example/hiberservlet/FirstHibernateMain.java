package com.example.hiberservlet;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class FirstHibernateMain {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(FirstHibernateEntity.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        session.getTransaction().begin();
                        FirstHibernateEntity first = new FirstHibernateEntity();

                        System.out.print("Enter name: ");
                        sc.nextLine();
                        String name_to_insert = sc.nextLine();

                        first.setName(name_to_insert);
                        session.persist(first);

                        session.getTransaction().commit();
                        break;

                    case 2:
                        FirstHibernateEntity fr = new FirstHibernateEntity();
                        String jpql = "SELECT fe.Name FROM FirstHibernateEntity fe WHERE fe.Id=1";
                        Query query = session.createQuery(jpql);
                        List<Object[]> results = query.getResultList();
//                        System.out.println("------------------------");
//                        System.out.println("| id | name |");
//
//                        for (Object[] result : results) {
//                            int id = (int) result[0];
//                            String name = (String) result[1];
//                            System.out.printf("| %d | %s |\n", id, name);
//                        }
//                        System.out.println("------------------------");
                        break;

                    default:
                        System.out.println("Error");
                }
                System.out.print("Want to continue (y/n): ");
                sc.nextLine();
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("n"))
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
