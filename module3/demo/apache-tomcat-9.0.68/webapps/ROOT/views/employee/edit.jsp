<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EDIT EMPLOYEE</title>
    <link rel="stylesheet" href="public/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="public/css/style.css">
</head>

<body>
<div class="app">
    <!-- Header -->
    <jsp:include page="../includes/header.jsp"></jsp:include>

    <!-- Content -->
    <div class="content row my-3 mx-3">
        <div class="col-2">
            <!-- Menu left -->
            <jsp:include page="../includes/menu_left.jsp"></jsp:include>
        </div>
        <div class="col-10">
            <h5 class="text-danger">EDIT EMPLOYEE</h5>
            <p class="text-success">
                <c:if test='${requestScope["message"] != null}'>
                    <span class="message">${requestScope["message"]}</span>
                </c:if>
            </p>
            <form method="post">
                <div class="mb-3">
                    <label class="form-label">Employee Name</label>
                    <input type="text" class="form-control" name="name" value="${employee.getName()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Birthday</label>
                    <input type="date" class="form-control" name="birthday" value="${employee.getBirthday()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">CMND</label>
                    <input type="text" class="form-control" name="cmnd" value="${employee.getCmnd()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Salary</label>
                    <input type="text" class="form-control" name="salary" value="${employee.getSalary()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone Number</label>
                    <input type="text" class="form-control" name="phoneNumber" value="${employee.getPhoneNumber()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="text" class="form-control" name="email" value="${employee.getEmail()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Address</label>
                    <input type="text" class="form-control" name="address" value="${employee.getAddress()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Position</label>
                    <select class="form-select" aria-label="Default select example" name="position">
                        <c:forEach var="position" items="${positionList}">
                            <c:if test="${employee.getIdPosition() == position.getId()}">
                                <option value="${position.getId()}">${position.getName()}</option>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="position" items="${positionList}">
                            <c:if test="${employee.getIdPosition() != position.getId()}">
                                <option value="${position.getId()}">${position.getName()}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Education Degree</label>
                    <select class="form-select" aria-label="Default select example" name="education_degree">
                        <c:forEach var="educationDegree" items="${educationDegreeList}">
                            <c:if test="${employee.getIdEducationDegree() == educationDegree.getId()}">
                                <option value="${educationDegree.getId()}">${educationDegree.getName()}</option>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="educationDegree" items="${educationDegreeList}">
                            <c:if test="${employee.getIdEducationDegree() != educationDegree.getId()}">
                                <option value="${educationDegree.getId()}">${educationDegree.getName()}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Division</label>
                    <select class="form-select" aria-label="Default select example" name="division">
                        <c:forEach var="division" items="${divisionList}">
                            <c:if test="${employee.getIdDivision() == division.getId()}">
                                <option value="${division.getId()}">${division.getName()}</option>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="division" items="${divisionList}">
                            <c:if test="${employee.getIdDivision() != division.getId()}">
                                <option value="${division.getId()}">${division.getName()}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>



                <button type="submit" class="btn btn-primary">Edit</button>
            </form>
        </div>
    </div>
</div>
</body>

</html>