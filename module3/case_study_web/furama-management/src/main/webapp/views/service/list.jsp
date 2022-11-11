<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LIST SERVICES</title>
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
            <h5 class="text-danger">LIST SERVICES  </h5>
            <div class="btn-group my-3 d-flex justify-content-between" role="group" aria-label="Basic mixed styles example">
                <a href="/service?action=create">
                    <button type="button" class="btn btn-success"><i class="bi bi-plus-circle me-2"></i>Create new service</button>
                </a>
                <form class="d-flex" method="post" action="/service?action=find">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="input_find">
                    <select class="form-select me-2" aria-label="Default select example" name="rentTypeFind">
                        <option selected value="">-- Choose Rent Type --</option>
                        <c:forEach var="rentType" items="${rentTypeList}">
                            <option value="${rentType.getId()}">${rentType.getName()}</option>
                        </c:forEach>
                    </select>
                    <select class="form-select me-2" aria-label="Default select example" name="serviceTypeFind">
                        <option selected value="">-- Choose Service Type --</option>
                        <c:forEach var="serviceType" items="${serviceTypeList}">
                            <option value="${serviceType.getId()}">${serviceType.getName()}</option>
                        </c:forEach>
                    </select>
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Service ID</th>
                    <th scope="col">Service Name</th>
                    <th scope="col">Area</th>
                    <th scope="col">Rent Cost</th>
                    <th scope="col">People Max</th>
                    <th scope="col">Rent Type</th>
                    <th scope="col">Service Type</th>
                    <th scope="col">Standard Room</th>
                    <th scope="col">Description Other Convenience</th>
                    <th scope="col">Pool Area</th>
                    <th scope="col">Floor</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="service" items="${serviceList}">
                    <tr>
                        <th scope="row">${service.getId()}</th>
                        <td>${service.getName()}</td>
                        <td>${service.getArea()}</td>
                        <td>${service.getRent_cost()}</td>
                        <td>${service.getPeopleMax()}</td>

                        <c:forEach var="rentType" items="${rentTypeList}">
                            <c:if test="${service.getIdRentType() == rentType.getId()}">
                                <td class="text-uppercase">${rentType.getName()}</td>
                            </c:if>
                        </c:forEach>

                        <c:forEach var="serviceType" items="${serviceTypeList}">
                            <c:if test="${service.getIdServiceType() == serviceType.getId()}">
                                <td>${serviceType.getName()}</td>
                            </c:if>
                        </c:forEach>

                        <td>${service.getStandardRoom()}</td>
                        <td>${service.getDescriptionOtherConvenience()}</td>
                        <td>${service.getPoolArea()}</td>
                        <td>${service.getFloor()}</td>
                        <td class="px-4">
                            <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                                <a href="/service?action=view&id=${service.getId()}"><button type="button" class="btn btn-sm btn-primary mx-1">View</button></a>
                                <a href="/service?action=edit&id=${service.getId()}"><button type="button" class="btn btn-sm btn-warning mx-1">Edit</button></a>
                                <button type="button" onclick="infoDelete('${service.getId()}','${service.getName()}')"
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