package com.example.hiberservel2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="student")
public class studentEntity {
    @Id
    private int book_id;
    private String std_name;
    private Date end_date, start_date;

    public int getId() {
        return book_id;
    }

    public void setId(int id) {
        this.book_id = id;
    }

    public String getName() {
        return std_name;
    }

    public void setName(String name) {
        this.std_name = name;
    }

    public Date getEnd_date(){
        return end_date;
    }

    public void setEnd_date(Date end_date){
        this.end_date = end_date;
    }

    public Date getStart_date(){
        return start_date;
    }

    public void setStart_date(Date start_date){
        this.start_date = start_date;
    }

}
