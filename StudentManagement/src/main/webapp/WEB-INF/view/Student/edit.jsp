<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
  <div class="container-fluid">
    <h1 class="mt-4">Sửa thông tin nhân viên</h1>
    <div class="card mb-4">
      <div class="card-header">
        <i class="fas fa-table mr-1"></i> Sửa thông tin nhân viên
      </div>
      <div class="card-body">
        <form action="<c:url value="/student/edit"/>" method="post">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <input type="hidden" name="id" value="${student.id}"
                       class="form-control" />
              </div>

              <div class="form-group">
                <label>Name</label>
                <input type="text" name="name" value="${student.getName()}" class="form-control" />
              </div>

              <div class="form-group">
                <label>Date of Birth</label>
                <input type="text" name="DOB" value="${student.getDOB()}" class="form-control" placeholder="YYYY-MM-DD"/>
              </div>

              <div class="form-group">
                <label>Email</label>
                <input type="text" name="email" value="${student.getEmail()}" class="form-control" />
              </div>

              <div class="form-group">
                <label>Phone</label>
                <input type="text" name="phone" value="${student.getPhone()}" class="form-control" />
              </div>

              <div class="form-group">
                <label>Address</label>
                <input type="text" name="address" value="${student.getAddress()}" class="form-control" />
              </div>


              <div class="form-group">
                <label>Classroom</label>
                <input type="number" name="idClassroom" value="${student.getIdClassroom()+1}" class="form-control" />
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
                   href="<c:url value="/students"/>">Quay lại</a>
                <button type="submit" class="btn btn-success">Lưu lại</button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</main>