<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EDIT CUSTOMER</title>
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
            <h5 class="text-danger">EDIT CUSTOMER</h5>
            <p class="text-success">
                <c:if test='${requestScope["message"] != null}'>
                    <span class="message">${requestScope["message"]}</span>
                </c:if>
            </p>
            <form method="post">
                <div class="mb-3">
                    <label class="form-label">Customer Type</label>
                    <select class="form-select" aria-label="Default select example" name="customerType">
                        <c:forEach var="customerType" items="${customerTypeList}">
                            <c:if test="${customer.getCustomerTypeId() == customerType.getId()}">
                                <option value="${customerType.getId()}">${customerType.getName()}</option>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="customerType" items="${customerTypeList}">
                            <c:if test="${customer.getCustomerTypeId() != customerType.getId()}">
                                <option value="${customerType.getId()}">${customerType.getName()}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Customer Name</label>
                    <input type="text" class="form-control" name="name" value="${customer.getName()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Birthday</label>
                    <input type="date" class="form-control" name="birthday" value="${customer.getBirthday()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Gender</label>
                    <div class="d-flex">
                        <c:if test="${customer.isGender()}">
                            <input type="radio" name="gender" value="true" checked="checked">
                            <label class="px-2 me-5">MALE</label><br>
                            <input type="radio" name="gender" value="false" >
                            <label class="px-2">FEMALE</label><br>
                        </c:if>
                        <c:if test="${!customer.isGender()}">
                            <input type="radio" name="gender" value="true" >
                            <label class="px-2 me-5">MALE</label><br>
                            <input type="radio" name="gender" value="false" checked="checked">
                            <label class="px-2">FEMALE</label><br>
                        </c:if>
                    </div>
                </div>
                <div class="mb-3">
                    <label class="form-label">CMND</label>
                    <input type="text" class="form-control" name="cmnd" value="${customer.getCmnd()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone Number</label>
                    <input type="text" class="form-control" name="phoneNumber" value="${customer.getPhoneNumber()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="text" class="form-control" name="email" value="${customer.getEmail()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Address</label>
                    <input type="text" class="form-control" name="address" value="${customer.getAddress()}">
                </div>


                <button type="submit" class="btn btn-primary">Edit</button>
            </form>
        </div>
    </div>
</div>
</body>

</html>