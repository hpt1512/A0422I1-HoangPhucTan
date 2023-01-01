<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Settings</h2>
    <form:form action="" method="post" modelAttribute="setting">
        <table>
            <tr>
                <td><form:label path="language">Language: </form:label></td>
                <td>
                    <form:select path="language">
                        <form:options items ="${languages}"></form:options>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:label path="pageSize">Page size: </form:label></td>
                <td>
                    <form:select path="pageSize">
                        <form:options items ="${pageSizes}"></form:options>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:label path="spamFilter">Spams filter: </form:label></td>
                <td><form:checkbox path="spamFilter"/>Enable spam filter</td>
            </tr>
            <tr>
                <td><form:label path="signature">Signature: </form:label></td>
                <td><form:input path="signature"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
