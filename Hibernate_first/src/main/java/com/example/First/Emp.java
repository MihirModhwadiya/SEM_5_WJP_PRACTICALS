package com.example.First;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Emp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            String jpql = "SELECT MAX(emp.salary), MIN(emp.salary), AVG(emp.salary), COUNT(emp.name) FROM EmployeeEntity emp";
            Query query = session.createQuery(jpql);
            Object[] result = (Object[]) query.getSingleResult();

            if (result != null) {
                Double maxSalary = (Double) result[0];
                Double minSalary = (Double) result[1];
                Double avgSalary = (Double) result[2];
                Long employeeCount = (Long) result[3];

                System.out.println("Maximum Salary: " + maxSalary);
                System.out.println("Minimum Salary: " + minSalary);
                System.out.println("Average Salary: " + avgSalary);
                System.out.println("Employee Count: " + employeeCount);
            } else {
                System.out.println("No data found.");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
