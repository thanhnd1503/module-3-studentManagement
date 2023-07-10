<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
    <div class="container-fluid">
        <h1 class="mt-4">Quản lý học viên</h1>
        <div class="card mb-4">
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Date of Birth</th>
                            <th>Address</th>
                            <th>Phone Number</th>
                            <th>Email</th>
                            <th>Classroom</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${students}" var="student">
                            <tr>
                                <td>${student.getId()}</td>
                                <td>${student.getName()}</td>
                                <td>${student.getDOB()}</td>
                                <td>${student.getAddress()}</td>
                                <td>${student.getPhone()}</td>
                                <td>${student.getEmail()}</td>
                                <td>${student.getNameClassroom()}</td>
                                <td>
                                    <button class="btn-edit">
                                        <a href="<c:url value="/student/edit"/>?id=${student.id}" class="btn btn-sm btn-primary">
                                            <i class="fas fa-pen-square"></i> Edit
                                        </a>
                                    </button>
                                    <button class="btn-delete">
                                        <a href="<c:url value="/student/remove"/>?id=${student.id}" class="btn btn-sm btn-danger">
                                            <i class="fas fa-trash"></i> Delete
                                        </a>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="text-right" style="padding-top: 5px;">
                        <button>
                            <a class="btn btn-secondary" href="<c:url value="/students"/>">Quay lại</a>
                        </button>
                        <button>
                            <a href="<c:url value="/student/add"/>" class="btn btn-primary">Create</a>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>