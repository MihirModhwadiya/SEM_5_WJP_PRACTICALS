package com.example.hiberservel2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
//@Table(name = "second")
public class secondEntity {

    @Id
    private int id;
    private String bookName;
    private String bookAuthor;

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getId() {

        return id;
    }


}
