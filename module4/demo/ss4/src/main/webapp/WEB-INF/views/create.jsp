<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 5/31/2022
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/create" method="post" modelAttribute="student">
    <label>Code student</label>
    <form:input type="text" path="codeStudent"/><br>
    <label>Name student</label>
    <form:input type="text" path="nameStudent"/><br>
    <label>Point</label>
    <form:input type="text" name="point" path="point"/><br>
    <label>Gender</label>
<%--    <form:select path="gender">--%>
<%--        <form:options items="${genderList}"></form:options>--%>
<%--    </form:select>--%>
<%--    <form:checkboxes path="gender" items="${genderList}"></form:checkboxes>--%>
    <form:radiobuttons path="gender" items="${genderList}"></form:radiobuttons>
    <button type="submit">Create</button>

</form:form>
</body>
</html>
