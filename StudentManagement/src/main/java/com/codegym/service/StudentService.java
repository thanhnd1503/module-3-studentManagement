package com.codegym.service;

import com.codegym.dto.StudentDto;

import java.util.List;


public interface StudentService {
    List<StudentDto> displayAll();

    StudentDto find(int id);
    void add(StudentDto studentDto);
    void edit(StudentDto studentDto);
    void remove(Integer id);

}
