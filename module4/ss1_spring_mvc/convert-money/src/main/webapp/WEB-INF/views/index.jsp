<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 23/11/2022
  Time: 6:31 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert Money</title>
</head>
<body>
    <form action="/convert" method="get">
        <label>Nhập USD :</label>
        <input type="number" name="usd">
        <button type="submit">Convert</button>
    </form>
    <label>VND :</label>
    <label>${vnd}</label>
</body>
</html>
