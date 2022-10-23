<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/10/2022
  Time: 5:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
    <style>
        td {
            padding: 10px 20px;
        }
        img {
            width: 100px;
        }
    </style>
</head>
<body>
    <table border="1">
        <tr>
            <td>STT</td>
            <td>Tên</td>
            <td>Ngày sinh</td>
            <td>Địa chỉ</td>
            <td>Ảnh</td>
        </tr>
        <c:forEach var="customer" items="${customerList}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${customer.getName()}</td>
                <td>${customer.getBirthday()}</td>
                <td>${customer.getAddress()}</td>
                <td>
                    <img src="img/${customer.getImage()}">
                </td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
