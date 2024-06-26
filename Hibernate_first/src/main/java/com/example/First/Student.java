package com.example.First;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentEntity.class)
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
                        StudentEntity first = new StudentEntity();

                        System.out.print("Enter Student name: ");
                        sc.nextLine();
                        String name_to_insert = sc.nextLine();
                        first.setStudentName(name_to_insert);

                        System.out.print("Enter Branch name: ");
                        String branch_name = sc.nextLine();
                        first.setBranch(branch_name);
                        session.persist(first);

                        session.getTransaction().commit();
                        break;
                    case 2:
                        List<StudentEntity> studentInfos = session.createQuery("from StudentEntity", StudentEntity.class).list();
                        for (StudentEntity std: studentInfos) {
                            System.out.printf("| %d | %s | %s |\n", std.getStudentId(), std.getStudentName(), std.getBranch());
                        }
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
