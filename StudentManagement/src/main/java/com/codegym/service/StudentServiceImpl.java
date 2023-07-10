package com.codegym.service;

import com.codegym.dao.StudentDao;
import com.codegym.dto.StudentDto;
import com.codegym.entity.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = null;

    public StudentServiceImpl() {
        this.studentDao = new StudentDao();
    }

    @Override
    public List<StudentDto> displayAll() {
        return studentDao.getAll();
    }

    @Override
    public StudentDto find(int id) {
        Student student = studentDao.get(id);
        return new StudentDto(student.getId(), student.getName(),student.getDOB(),student.getAddress(),student.getPhone(),
                student.getEmail(), student.getIdClassroom(), student.isStatus());
    }
    @Override
    public void add(StudentDto studentDto) {
        Student student = new Student(
                studentDto.getName(),studentDto.getDOB(),studentDto.getAddress(),studentDto.getPhone(),
                studentDto.getEmail(), studentDto.getIdClassroom(), studentDto.isStatus());
        studentDao.insert(student);
    }
    @Override
    public void edit(StudentDto studentDto) {
        Student student = new Student(studentDto.getId(),studentDto.getName(),studentDto.getDOB(),studentDto.getAddress(),studentDto.getPhone(),
                studentDto.getEmail(), studentDto.getIdClassroom(), studentDto.isStatus());
        studentDao.update(student);
    }
    @Override
    public void remove(Integer id) {
        studentDao.delete(id);
    }
}
