package com.codegym.entity;

import java.sql.Date;

public class Student {
    private int id;
    private String name;
    private Date DOB;
    private String address;
    private String phone;
    private String email;
    private int idClassroom;
    private boolean isStatus;

    //Constructor
    public Student() {}

    public Student(String name, Date DOB, String address, String phone, String email, int idClassroom, boolean isStatus) {
        this.name = name;
        this.DOB = DOB;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.idClassroom = idClassroom;
        this.isStatus = isStatus;
    }

    public Student(int id, String name, Date DOB, String address, String phone, String email, int idClassroom, boolean isStatus) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.idClassroom = idClassroom;
        this.isStatus = isStatus;
    }

    //Getter & Setter
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

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(int idClassroom) {
        this.idClassroom = idClassroom;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }

}
