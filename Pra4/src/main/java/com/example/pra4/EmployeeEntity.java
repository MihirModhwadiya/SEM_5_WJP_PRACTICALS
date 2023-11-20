package com.example.pra4;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Column(name = "salary", nullable = true, precision = 0)
    private Double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
