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
</head>
<body>
<h1>Danh sách sinh viên</h1>
<a href="/student?action=add"> Them moi</a>
<table border="1">
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
            <td>${student.getClassId()}</td>
            <td>${student.getEmail()}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
