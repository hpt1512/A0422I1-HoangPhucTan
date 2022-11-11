<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 10/19/2022
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<h1>Danh sách sinh viên</h1>
<form action="/student" method="get">
    <input hidden type="text" name="action" value="search">
    <input type="text" name="searchName" placeholder="nhập tên">
    <input type="text" name="searchAccount" placeholder="nhập account">
    <select name="classId">
        <option value="">--Chọn lơp-- </option>
        <c:forEach var="cls" items="${classList}">
            <option value="${cls.id}">${cls.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Search</button>
</form>
<a href="/student?action=add"> Them moi</a>
<c:if test="${mess !=null}">
    <span class="text-danger">${mess}</span>
</c:if>
<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>Id</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Birthday</th>
        <th>Point</th>
        <th>Rank</th>
        <th>Account</th>
        <th>ClassID</th>
        <th>Email</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
             <c:if test="${student.isGender()}">
                 <td>Nam</td>
             </c:if>
            <c:if test="${!student.isGender()}">
                <td>Nữ</td>
            </c:if>
            <td>${student.getBirthday()}</td>
            <td>${student.getPoint()}</td>

            <c:choose>
                <c:when test="${student.getPoint()>=8}">
                    <td>Giỏi</td>
                </c:when>
                <c:when test="${student.getPoint()>=7}">
                    <td>Khá</td>
                </c:when>
                <c:when test="${student.getPoint()>=5}">
                    <td>trung bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yêu sắc yếu</td>
                </c:otherwise>
            </c:choose>

            <td>${student.getAccount()}</td>

            <c:forEach var="cls" items="${classList}">
                <c:if test="${cls.id==student.getClassId()}">
                    <td>${cls.name}</td>
                </c:if>
            </c:forEach>
            <td>${student.getEmail()}</td>
            <td>
                <button type="button" onclick="infoDelete('${student.getId()}','${student.getName()}')" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>

</table>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/student" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input name="action" value="delete" hidden>
                    <input name="deleteId" id="deleteId" hidden>
                    <span class="text-danger">Bạn có muốn xoá sinh viên </span><span id="deleteName"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </form>

    </div>
</div>
<script>
    function infoDelete(id, name) {
      document.getElementById("deleteName").innerText=name;
      document.getElementById("deleteId").value=id;
    }
</script>
</body>
</html>
