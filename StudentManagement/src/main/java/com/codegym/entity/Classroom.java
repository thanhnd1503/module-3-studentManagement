package com.codegym.entity;

public class Classroom {
    private int id;
    private String name;

    // Constructor
    public Classroom() {}

    public Classroom(String name) {
        this.name = name;
    }

    public Classroom(int id, String name) {
        this.id = id;
        this.name = name;
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
}
