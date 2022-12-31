package com.example.firstapi.model;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Student")
@Data
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int msv;
    @Column
    private String clss;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private double mark;

    public Student(){

    }
    
    public Student(int msv, String clss, String name, String email, double mark) {
        this.msv = msv;
        this.clss = clss;
        this.name = name;
        this.email = email;
        this.mark = mark;
    }

    public int getMsv() {
        return this.msv;
    }

    public void setMsv(int msv) {
        this.msv = msv;
    }

    public String getClss() {
        return this.clss;
    }

    public void setClss(String clss) {
        this.clss = clss;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMark() {
        return this.mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

}
