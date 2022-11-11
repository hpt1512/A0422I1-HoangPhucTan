<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Danh Sách Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
<%--Header--%>
<%@include file="includes/header.jsp" %>

<!-- Content -->
<div id="content" class="row">
    <div class="col-4 pitch__list__menu">
        <div class="pitch__list__menu__title">
            <i class="bi bi-geo-alt"></i>
            <span>Quận/Huyện</span>
        </div>
        <ul class="pitch__list__menu__nav">
            <li class="pitch__list__menu__nav__item">
                <i class="bi bi-caret-right-fill"></i>
                Liên Chiểu
            </li>
            <li class="pitch__list__menu__nav__item">
                <i class="bi bi-caret-right-fill"></i>
                Cẩm Lệ
            </li>
            <li class="pitch__list__menu__nav__item">
                <i class="bi bi-caret-right-fill"></i>
                Thanh Khê
            </li>
            <li class="pitch__list__menu__nav__item">
                <i class="bi bi-caret-right-fill"></i>
                Hải Châu
            </li>
            <li class="pitch__list__menu__nav__item">
                <i class="bi bi-caret-right-fill"></i>
                Sơn Trà
            </li>
            <li class="pitch__list__menu__nav__item">
                <i class="bi bi-caret-right-fill"></i>
                Ngũ Hành Sơn
            </li>
            <li class="pitch__list__menu__nav__item">
                <i class="bi bi-caret-right-fill"></i>
                Hoà Vang
            </li>
            <li class="pitch__list__menu__nav__item">
                <i class="bi bi-caret-right-fill"></i>
                Hoàng Sa
            </li>
        </ul>
    </div>
    <div class="col-8 pitch__list__content">

        <form class="input-group flex-nowrap" method="post" action="/products?action=find">
            <input type="text" class="form-control" placeholder="Nhập tên sản phẩm để tìm kiếm" name="input_find">
            <button type="submit" class="btn btn-success">Tìm</button>
        </form>

        <a href="/products?action=create">Thêm mới sản phẩm</a>

        <ul class="pitch__list__content__nav">
            <c:forEach items='${requestScope["products"]}' var="product">
                <li class="pitch__list__content__nav__item">
                    <div class="pitch__list__content__nav__item__info">
                        <span class="name__pitch">${product.getName()}</span>
                        <span style="color: red" class="">${product.getPrice()}</span>
                        <span class="">${product.getDescription()}</span>
                        <span class="">${product.getProducer()}</span>
                    </div>
                    <div class="btn__div" style="position: absolute; right: 10px">
                        <a href="/products?action=view&id=${product.getId()}">
                            <button type="button" class="btn btn-success ">View</button>
                        </a>
                        <a href="/products?action=edit&id=${product.getId()}">
                            <button type="button" class="btn btn-success ">Edit</button>
                        </a>
                        <button type="button" onclick="infoDelete('${product.getId()}','${product.getName()}')"
                                class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#exampleModal">
                            Delete
                        </button>
                    </div>
                </li>
            </c:forEach>

        </ul>

    </div>
</div>

<%--Footer--%>
<%@include file="includes/footer.jsp" %>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/products" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">XOÁ SẢN PHẨM</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input name="action" value="delete" hidden>
                    <input name="id" id="deleteId" hidden>
                    <span class="text-danger">Bạn có muốn xoá sản phẩm  </span><span id="deleteName"></span>
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
