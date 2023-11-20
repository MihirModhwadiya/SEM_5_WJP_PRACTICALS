package com.example.pra3;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @Column(name = "student_id", nullable = false)
    private int studentId;
    @Column(name = "student_name", nullable = true, length = 50)
    private String studentName;
    @Column(name = "branch", nullable = false, length = 255)
    private String branch;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

}
