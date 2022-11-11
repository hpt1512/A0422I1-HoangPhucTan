<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VIEW SERVICE</title>
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
            <h5 class="text-danger">SERVICE DETAIL</h5>
            <div>
                <div class="py-2 px-4">
                    <span class="me-3">Service Name : </span>
                    <span class="text-success fw-bold">${service.getName()}</span>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Area : </span>
                    <span class="text-success fw-bold">${service.getArea()}</span>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Rent Cost : </span>
                    <span class="text-success fw-bold">${service.getRent_cost()}</span>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">People Max : </span>
                    <span class="text-success fw-bold">${service.getPeopleMax()}</span>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Rent Type : </span>
                    <c:forEach var="rentType" items="${rentTypeList}">
                        <c:if test="${rentType.getId() == service.getIdRentType()}">
                            <span class="text-success fw-bold">${rentType.getName()}</span>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Service Type : </span>
                    <c:forEach var="serviceType" items="${serviceTypeList}">
                        <c:if test="${serviceType.getId() == service.getIdServiceType()}">
                            <span class="text-success fw-bold">${serviceType.getName()}</span>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Standard Room : </span>
                    <span class="text-success fw-bold">${service.getStandardRoom()}</span>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Description Other Convenience : </span>
                    <span class="text-success fw-bold">${service.getDescriptionOtherConvenience()}</span>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Pool Area : </span>
                    <span class="text-success fw-bold">${service.getPoolArea()}</span>
                </div>
                <div class="py-2 px-4">
                    <span class="me-3">Floor : </span>
                    <span class="text-success fw-bold">${service.getFloor()}</span>
                </div>
            </div>
            <div class="btn-group py-2 px-4" role="group" aria-label="Basic mixed styles example">
                <a href="/service?action=edit&id=${service.getId()}"><button type="button" class="btn btn-warning me-2">Edit</button></a>
                <button type="button" onclick="infoDelete('${service.getId()}','${service.getName()}')"
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
        <form action="/service" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">DELETE SERVICE</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input name="action" value="delete" hidden>
                    <input name="id" id="deleteId" hidden>
                    <span class="text-danger">Delete service  </span><span id="deleteName"></span>
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