<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Borrow book</title>
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
            <h5 class="text-danger">MƯỢN SÁCH</h5>
            <p class="text-success">
                <c:if test='${requestScope["message"] != null}'>
                    <span class="message">${requestScope["message"]}</span>
                </c:if>
            </p>
            <form action="/borrow-card?action=create" method="post">
                <div class="mb-3">
                    <label class="form-label">Mã phiếu mượn</label>
                    <input type="text" class="form-control" name="idBorrow">
                </div>
                <div class="mb-3">
                    <label class="form-label">Tên sách</label>
                    <select class="form-select" aria-label="Default select example" name="bookName">
                        <option class="text-uppercase" value="${book.getId()}">${book.getName()}</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Tên học sinh</label>
                    <select class="form-select" aria-label="Default select example" name="studentName">
                        <option selected>-- Chọn học sinh --</option>
                        <c:forEach var="student" items="${studentList}">
                            <option class="text-uppercase" value="${student.getId()}">${student.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Ngày mượn sách</label>
                    <input type="date" class="form-control" name="dateStart">
                </div>
                <div class="mb-3">
                    <label class="form-label">Ngày trả sách</label>
                    <input type="date" class="form-control" name="dateEnd">
                </div>

                <button type="submit" class="btn btn-primary">Mượn</button>
<%--                <a></a><button type="submit" class="btn btn-primary">Mượn</button>--%>
            </form>
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