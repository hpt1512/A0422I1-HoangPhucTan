<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LIST CUSTOMERS</title>
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
            <h5 class="text-danger">LIST CUSTOMERS</h5>
            <div class="btn-group my-3 d-flex justify-content-between" role="group" aria-label="Basic mixed styles example">
                <a href="/customer?action=create">
                    <button type="button" class="btn btn-success"><i class="bi bi-plus-circle me-2"></i>Create new customer</button>
                </a>
                <form class="d-flex" method="post" action="/customer?action=find">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="input_find">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Customer ID</th>
                    <th scope="col">Customer Type</th>
                    <th scope="col">Customer Name</th>
                    <th scope="col">Birthday</th>
                    <th scope="col">Gender</th>
                    <th scope="col">CMND</th>
                    <th scope="col">Phone Number</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${customerList}">
                    <tr>
                        <th scope="row">${customer.getId()}</th>
                        <c:forEach var="customerType" items="${customerTypeList}">
                            <c:if test="${customer.getCustomerTypeId() == customerType.getId()}">
                                <td>${customerType.getName()}</td>
                            </c:if>
                        </c:forEach>
                        <td>${customer.getName()}</td>
                        <td>${customer.getBirthday()}</td>
                        <c:if test="${customer.isGender()}">
                            <td>Male</td>
                        </c:if>
                        <c:if test="${!customer.isGender()}">
                            <td>Female</td>
                        </c:if>

                        <td>${customer.getCmnd()}</td>
                        <td>${customer.getPhoneNumber()}</td>
                        <td>${customer.getEmail()}</td>
                        <td>${customer.getAddress()}</td>
                        <td class="px-4">
                            <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                                <a href="/customer?action=view&id=${customer.getId()}"><button type="button" class="btn btn-sm btn-primary mx-1">View</button></a>
                                <a href="/customer?action=edit&id=${customer.getId()}"><button type="button" class="btn btn-sm btn-warning mx-1">Edit</button></a>
<%--                                <a href="/customer?action=delete&id=${customer.getId()}"><button type="button" class="btn btn-sm btn-danger">Delete</button></a>--%>
                                <button type="button" onclick="infoDelete('${customer.getId()}','${customer.getName()}')"
                                        class="btn btn-sm btn-danger mx-1" data-bs-toggle="modal"
                                        data-bs-target="#exampleModal">
                                    Delete
                                </button>
                            </div>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/customer" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">DELETE CUSTOMER</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input name="action" value="delete" hidden>
                    <input name="id" id="deleteId" hidden>
                    <span class="text-danger">Delete custmer  </span><span id="deleteName"></span>
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