package com.codegym.controller;

import com.codegym.dto.StudentDto;
import com.codegym.service.StudentService;
import com.codegym.service.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "StudentServlet",
        urlPatterns = {"/","/students", "/student/add",
                "/student/edit", "/student/remove"})
public class StudentServlet extends HttpServlet {

    private StudentService studentService = null; // tạo 1 đối tượng student

    @Override
    public void init() {
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action) {
            case "/":
            case "/students":
                req.setAttribute("students", studentService.displayAll());
                req.getRequestDispatcher("/WEB-INF/view/Student/index.jsp").forward(req, resp);
                break;

            case "/student/add":
                req.getRequestDispatcher("/WEB-INF/view/Student/add.jsp").forward(req, resp);
                break;
            case "/student/edit":
                int editId = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("student", studentService.find(editId));
//                biến student phải trùng tên với biến gọi trong edit.jsp
                req.getRequestDispatcher("/WEB-INF/view/Student/edit.jsp").forward(req, resp);
                break;
            case "/student/remove":
                int removeId = Integer.parseInt(req.getParameter("id"));
                studentService.remove(removeId);
                resp.sendRedirect(req.getContextPath() + "/students");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        String name = request.getParameter("name");
        Date dob = Date.valueOf(request.getParameter("DOB"));
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Integer idClassroom = Integer.parseInt(request.getParameter("idClassroom"));
        Boolean isStatus = Boolean.parseBoolean(request.getParameter("isStatus"));

        StudentDto studentDto = new StudentDto(name, dob, address, phone, email, idClassroom, isStatus);

        switch (action) {
            case "/student/add":
                studentService.add(studentDto);
                response.sendRedirect(request.getContextPath() + "/students");
                break;
            case "/student/edit":
                Integer id = Integer.valueOf(request.getParameter("id"));
                StudentDto editingStudent = studentService.find(id);
                editingStudent.setName(name);
                editingStudent.setDOB(dob);
                editingStudent.setEmail(email);
                editingStudent.setPhone(phone);
                editingStudent.setAddress(address);
                editingStudent.setIdClassroom(idClassroom);
                editingStudent.setStatus(isStatus);
                studentService.edit(editingStudent);
                response.sendRedirect(request.getContextPath() + "/students");
                break;
        }
    }
}
