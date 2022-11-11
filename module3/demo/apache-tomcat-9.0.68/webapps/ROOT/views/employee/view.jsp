<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VIEW EMPLOYEE</title>
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
            <h5 class="text-danger">EMPLOYEE DETAIL</h5>
            <div>
                <div class="py-2 px-4">
                    <span class="me-3">Employee Name : </span>
                    <span class="text-success fw-bold">${employee.getName()}</span>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Birthday : </span>
                    <span class="text-success fw-bold">${employee.getBirthday()}</span>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">CMND : </span>
                    <span class="text-success fw-bold">${employee.getCmnd()}</span>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Salary : </span>
                    <span class="text-success fw-bold">${employee.getSalary()}</span>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Phone Number : </span>
                    <span class="text-success fw-bold">${employee.getPhoneNumber()}</span>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Email : </span>
                    <span class="text-success fw-bold">${employee.getEmail()}</span>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Address : </span>
                    <span class="text-success fw-bold">${employee.getAddress()}</span>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Position : </span>
                    <c:forEach var="position" items="${positionList}">
                        <c:if test="${position.getId() == employee.getIdPosition()}">
                            <span class="text-success fw-bold">${position.getName()}</span>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Eduaction Degree : </span>
                    <c:forEach var="educationDegree" items="${educationDegreeList}">
                        <c:if test="${educationDegree.getId() == employee.getIdEducationDegree()}">
                            <span class="text-success fw-bold">${educationDegree.getName()}</span>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Division : </span>
                    <c:forEach var="division" items="${divisionList}">
                        <c:if test="${division.getId() == employee.getIdDivision()}">
                            <span class="text-success fw-bold">${division.getName()}</span>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
            <div class="btn-group py-2 px-4" role="group" aria-label="Basic mixed styles example">
                <a href="/employee?action=edit&id=${employee.getId()}"><button type="button" class="btn btn-warning me-2">Edit</button></a>
                <button type="button" onclick="infoDelete('${employee.getId()}','${employee.getName()}')"
                        class="btn btn-sm btn-danger mx-1" data-bs-toggle="modal"
                        data-bs-target="#exampleModal">
                    Delete
                </button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/employee" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">DELETE EMPLOYEE</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input name="action" value="delete" hidden>
                    <input name="id" id="deleteId" hidden>
                    <span class="text-danger">Delete employee  </span><span id="deleteName"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">OK</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
<script>
    function infoDelete(id, name) {
        document.getElementById("deleteName").innerText = name;
        document.getElementById("deleteId").value = id;
    }
</script>

</body>

</html>