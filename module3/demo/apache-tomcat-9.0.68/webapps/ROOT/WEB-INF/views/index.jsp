<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 23/11/2022
  Time: 8:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
    <h2>Caculator</h2>
    <form action="/count" method="get">
        <input type="number" name="num1">
        <input type="number" name="num2"><br><br>
        <button type="submit" value="+" name="calculation">Add +</button>
        <button type="submit" value="-" name="calculation">Sub -</button>
        <button type="submit" value="*" name="calculation">Mul *</button>
        <button type="submit" value="/" name="calculation">Div /</button>
    </form>
    <h3>Result : ${result}</h3>
</body>
</html>
