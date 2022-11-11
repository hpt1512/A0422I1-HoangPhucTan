<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EDIT SERVICE</title>
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
            <h5 class="text-danger">EDIT SERVICE</h5>
            <p class="text-success">
                <c:if test='${requestScope["message"] != null}'>
                    <span class="message">${requestScope["message"]}</span>
                </c:if>
            </p>
            <form method="post">
                <div class="mb-3">
                    <label class="form-label">Service Name</label>
                    <input type="text" class="form-control" name="name" value="${service.getName()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Area</label>
                    <input type="number" class="form-control" name="area" value="${service.getArea()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Rent Cost</label>
                    <input type="number" class="form-control" name="rent_cost" value="${service.getRent_cost()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">People Max</label>
                    <input type="number" class="form-control" name="people_max" value="${service.getPeopleMax()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Rent Type</label>
                    <select class="form-select" aria-label="Default select example" name="rent_type">
                        <c:forEach var="rentType" items="${rentTypeList}">
                            <c:if test="${service.getIdRentType() == rentType.getId()}">
                                <option value="${rentType.getId()}">${rentType.getName()}</option>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="rentType" items="${rentTypeList}">
                            <c:if test="${service.getIdRentType() != rentType.getId()}">
                                <option value="${rentType.getId()}">${rentType.getName()}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Service Type</label>
                    <select class="form-select" aria-label="Default select example" name="service_type">
                        <c:forEach var="serviceType" items="${serviceTypeList}">
                            <c:if test="${service.getIdServiceType() == serviceType.getId()}">
                                <option value="${serviceType.getId()}">${serviceType.getName()}</option>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="serviceType" items="${serviceTypeList}">
                            <c:if test="${service.getIdServiceType() != serviceType.getId()}">
                                <option value="${serviceType.getId()}">${serviceType.getName()}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Standard Room</label>
                    <input type="text" class="form-control" name="standard_room" value="${service.getStandardRoom()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Description Other Convenience</label>
                    <input type="text" class="form-control" name="description_other_convenience" value="${service.getDescriptionOtherConvenience()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Pool Area</label>
                    <input type="number" class="form-control" name="pool_area" value="${service.getPoolArea()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Floor	</label>
                    <input type="number" class="form-control" name="floor" value="${service.getFloor()}">
                </div>


                <button type="submit" class="btn btn-primary">Edit</button>
            </form>
        </div>
    </div>
</div>
</body>

</html>