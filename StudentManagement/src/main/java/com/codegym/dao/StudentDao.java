package com.codegym.dao;

import com.codegym.connection.JdbcConnection;
import com.codegym.dto.StudentDto;
import com.codegym.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class StudentDao {
    private List<StudentDto> studentsDto = null;

    public List<StudentDto> getAll() {
        studentsDto = new LinkedList<>();
        try{
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT S.id, S.name, S.DOB, S.address, S.phone, S.email, S.idClassroom, Classroom.name " +
                            "FROM Student S, Classroom " +
                            "WHERE S.idClassroom = Classroom.id and S.isStatus = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                StudentDto studentDto = new StudentDto();
                studentDto.setId(resultSet.getInt("S.id"));
                studentDto.setName(resultSet.getString("S.name"));
                studentDto.setDOB(resultSet.getDate("S.DOB"));
                studentDto.setAddress(resultSet.getString("S.address"));
                studentDto.setPhone(resultSet.getString("S.phone"));
                studentDto.setEmail(resultSet.getString("S.email"));
                studentDto.setIdClassroom(resultSet.getInt("S.idClassroom"));
                studentDto.setNameClassroom(resultSet.getString("Classroom.name"));
                studentsDto.add(studentDto);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsDto;
    }

    public Student get(int id) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT * FROM Student WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setDOB(resultSet.getDate("dob"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setAddress(resultSet.getString("address"));
                student.setStatus(resultSet.getBoolean("isStatus"));
                return student;
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Student();
    }

    public void insert(Student student) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "INSERT INTO Student (name,dob,address, phone,email, idClassroom, isStatus)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, student.getDOB());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getIdClassroom());
            preparedStatement.setBoolean(7, student.isStatus());

            if(preparedStatement.executeUpdate() > 0) {
                System.out.println("Added personnel successfully.");
            } else {
                System.out.println("Failed to insert personnel.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "UPDATE Student SET name = ?, email = ?, DOB = ?, address = ?, phone = ?, " +
                    "idClassroom= ?, isStatus= ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setDate(3, student.getDOB());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setInt(6, student.getIdClassroom());
            preparedStatement.setBoolean(7, student.isStatus());
            preparedStatement.setInt(8, student.getId());

            if(preparedStatement.executeUpdate() > 0) {
                System.out.println("Edited personnel successfully.");
            } else {
                System.out.println("Failed to edit personnel.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "UPDATE Student SET Student.isStatus = 0 WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            if(preparedStatement.executeUpdate() > 0) {
                System.out.println("Removed customer successfully.");
            } else {
                System.out.println("Failed to remove customer.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
