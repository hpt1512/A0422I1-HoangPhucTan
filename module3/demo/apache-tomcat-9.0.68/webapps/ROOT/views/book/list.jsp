<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book</title>
    <!-- Link -->
    <jsp:include page="../includes/head_link.jsp"></jsp:include>
</head>

<body>
<div class="app">
    <!-- Header -->
    <jsp:include page="../includes/header.jsp"></jsp:include>
    <!-- Content -->
    <div class="content row my-3 mx-3">
        <div class="col-2">
            <!-- Header -->
            <jsp:include page="../includes/admin_menu_left.jsp"></jsp:include>
        </div>
        <div class="col-10">
            <h4 class="text-danger">DANH SÁCH SÁCH</h4>
            <div class="btn-group my-3 d-flex justify-content-between" role="group" aria-label="Basic mixed styles example">
                <a href="/book?action=create">
                    <button type="button" class="btn btn-success"><i class="bi bi-plus-circle me-2"></i>Thêm mới</button>
                </a>
                <form class="d-flex" method="post" action="/book?action=find">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="input_find">
                    <button class="btn btn-success w-50" type="submit">Tìm kiếm</button>
                </form>
            </div>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">ID</th>
                    <th scope="col">Tên sách</th>
                    <th scope="col">Tác giả</th>
                    <th scope="col">Mô tả</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${bookList}" varStatus="status">
                    <tr class="align-middle">
                        <th scope="row">${status.count}</th>
                        <td>${book.getId()}</td>
                        <td>${book.getName()}</td>
                        <td>${book.getAuthor()}</td>
                        <td>${book.getDescription()}</td>
                        <td>${book.getCount()}</td>
                        <td class="px-4">
                            <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                                <a href="/book?action=borrow&id=${book.getId()}"><button type="button" class="btn btn-sm btn-warning mx-1">Mượn</button></a>
                            </div>
                        </td>
<%--                        <td class="px-4">--%>
<%--                            <div class="btn-group" role="group" aria-label="Basic mixed styles example">--%>
<%--                                <a href="/book?action=edit&id=${company.getId()}"><button type="button" class="btn btn-sm btn-warning mx-1">Sửa</button></a>--%>
<%--                                <button type="button" onclick="infoDelete('${company.getId()}','${company.getName()}')"--%>
<%--                                        class="btn btn-sm btn-danger mx-1" data-bs-toggle="modal"--%>
<%--                                        data-bs-target="#exampleModal">--%>
<%--                                    Xoá--%>
<%--                                </button>--%>
<%--                            </div>--%>
<%--                        </td>--%>
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
        <form action="/admin-company" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">XOÁ NGƯỜI DÙNG</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input name="action" value="delete" hidden>
                    <input name="id" id="deleteId" hidden>
                    <span class="text-danger">Xoá người dùng  </span><span id="deleteName"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">OK</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="public/bootstrap-5.1.3-dist/js/bootstrap.bundle.js"></script>
<script>
    function infoDelete(id, name) {
        document.getElementById("deleteName").innerText = name;
        document.getElementById("deleteId").value = id;
    }
</script>
</body>
</html>