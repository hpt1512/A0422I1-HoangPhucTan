<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 23/11/2022
  Time: 6:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>App Dictionary</title>
</head>
<body>
    <form action="/find" method="get">
        <label>Enter English word :</label>
        <input type="text" name="elWord">
        <button type="submit">Find</button>
    </form>
    <label>Vietnamese word: </label>
    <label>${vieWord}</label>
</body>
</html>
