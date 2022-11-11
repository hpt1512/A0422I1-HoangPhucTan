<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ADD NEW EMPLOYEE</title>
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
            <h5 class="text-danger">CREATE NEW EMPLOYEE</h5>
            <p class="text-success">
                <c:if test='${requestScope["message"] != null}'>
                    <span class="message">${requestScope["message"]}</span>
                </c:if>
            </p>
            <form action="/employee?action=create" method="post">
                <div class="mb-3">
                    <label class="form-label">Employee Name</label>
                    <input type="text" class="form-control" name="name">
                </div>
                <div class="mb-3">
                    <label class="form-label">Birthday</label>
                    <input type="date" class="form-control" name="birthday">
                </div>
                <div class="mb-3">
                    <label class="form-label">CMND</label>
                    <input type="text" class="form-control" name="cmnd">
                </div>
                <div class="mb-3">
                    <label class="form-label">Salary</label>
                    <input type="number" class="form-control" name="salary">
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone Number</label>
                    <input type="text" class="form-control" name="phoneNumber">
                </div>
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="text" class="form-control" name="email">
                </div>
                <div class="mb-3">
                    <label class="form-label">Address</label>
                    <input type="text" class="form-control" name="address">
                </div>
                <div class="mb-3">
                    <label class="form-label">Position</label>
                    <select class="form-select" aria-label="Default select example" name="position">
                        <option selected>Choose position</option>
                        <c:forEach var="position" items="${positionList}">
                            <option value="${position.getId()}">${position.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Education Degree</label>
                    <select class="form-select" aria-label="Default select example" name="education_degree">
                        <option selected>Choose education degree</option>
                        <c:forEach var="educationDegree" items="${educationDegreeList}">
                            <option value="${educationDegree.getId()}">${educationDegree.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Division</label>
                    <select class="form-select" aria-label="Default select example" name="division">
                        <option selected>Choose division</option>
                        <c:forEach var="division" items="${divisionList}">
                            <option value="${division.getId()}">${division.getName()}</option>
                        </c:forEach>
                    </select>
                </div>


                <button type="submit" class="btn btn-primary">Create</button>
            </form>
        </div>
    </div>
</div>
</body>

</html>