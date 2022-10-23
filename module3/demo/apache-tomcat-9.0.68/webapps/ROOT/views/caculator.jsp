<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/10/2022
  Time: 7:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
    <style>
        label, input, select, button {
            padding: 10px 10px;
            margin: 10px;
        }
    </style>
</head>
<body>
    <h1>Simple Caculator</h1>
    <form action="/result" method="post">
        <label>First operand: </label> <br>
        <input type="number" name="first_operand"> <br>
        <label>Operator: </label> <br>
        <select name="operator">
            <option>+</option>
            <option>-</option>
            <option>*</option>
            <option>/</option>
        </select> <br>
        <label>Second operand: </label> <br>
        <input type="number" name="second_operand"> <br>
        <button type="submit">Caculate</button>
    </form>
</body>
</html>
