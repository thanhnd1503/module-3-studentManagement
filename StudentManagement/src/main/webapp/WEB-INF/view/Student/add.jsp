<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
    <div class="container-fluid">
        <h1 class="mt-4">Thêm nhân viên mới</h1>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table mr-1"></i> Thêm nhân viên mới
            </div>
            <div class="card-body">
                <form action="<c:url value="/student/add"/>" method="post">
                    <div class="row">
                        <div class="col-md-6">

                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" name="name" value="" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label>Date of Birth</label>
                                <input type="text" name="DOB" value="" class="form-control" placeholder="YYYY-MM-DD"/>
                            </div>

                            <div class="form-group">
                                <label>Address</label>
                                <input type="text" name="address" value="" class="form-control"/>
                            </div>


                            <div class="form-group">
                                <label>Phone</label>
                                <input type="text" name="phone" value="" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label>Email</label>
                                <input type="text" name="email" value="" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label>Classroom</label>
                                <select id="idClassroom" name="idClassroom">
                                    <option value="1">Class A</option>
                                    <option value="2">Class B</option>
                                    <option value="3">Class C</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Status</label>
                                <select id="isStatus" name="isStatus">
                                    <option value="true">Active</option>
                                    <option value="false">Inactive</option>
                                </select>
                            </div>

                        </div>
                        <div class="col-12 mt-3">
                            <div class="form-group">
                                <a class="btn btn-secondary"
                                   href="<c:url value="//students"/>">Quay lại</a>
                                <button type="submit" class="btn btn-success">Lưu lại</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</main>