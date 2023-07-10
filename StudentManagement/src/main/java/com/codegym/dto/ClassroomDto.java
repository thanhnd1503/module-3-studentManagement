package com.codegym.dto;

public class ClassroomDto {
    private int id;
    private String name;

    // Constructor
    public ClassroomDto() {}

    public ClassroomDto(String name) {
        this.name = name;
    }

    public ClassroomDto(int id, String name) {
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
