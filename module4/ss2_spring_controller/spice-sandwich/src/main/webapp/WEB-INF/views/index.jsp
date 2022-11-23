<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 23/11/2022
  Time: 7:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spice Sandwich</title>
</head>
<body>
    <h3>Sandwich Condiments</h3>
    <form action="/save" method="get">
        <input type="checkbox" name="spice" value="Lettuce"> Lettuce
        <input type="checkbox" name="spice" value="Tomato"> Tomato
        <input type="checkbox" name="spice" value="Mustard"> Mustard
        <input type="checkbox" name="spice" value="Sprouts"> Sprouts
        <br><br><button type="submit">Save</button>
    </form>

    <c:forEach var="spice" items="${spices}">
        <span style="display: block">${spice}</span>
    </c:forEach>

</body>
</html>
