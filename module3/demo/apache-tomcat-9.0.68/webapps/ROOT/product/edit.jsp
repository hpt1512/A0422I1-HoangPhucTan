<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Administrator--%>
<%--  Date: 24/10/2022--%>
<%--  Time: 8:16 CH--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>


<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Sửa Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
<!-- Header -->
<header id="header">
    <div class="header__img" style="height: 60px">

    </div>
    <nav>
        <ul class="header__nav">
            <li class="header__nav__item"><a href="/products">Trang chủ</a></li>
            <li class="header__nav__item"><a href="">Công ty</a></li>
            <li class="header__nav__item"><a href="">Sự kiện, ưu đãi</a></li>
            <li class="header__nav__item border__right--none"><a href="">Góp ý</a></li>
        </ul>
    </nav>
</header>
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
        <h3 style="color: green">Edit product</h3>
        <p>
            <c:if test='${requestScope["message"] != null}'>
                <span class="message">${requestScope["message"]}</span>
            </c:if>
        </p>
        <form action="/products?action=edit" method="post">
            <div class="mb-3">
<%--                <label  class="form-label">ID</label>--%>
                <input type="hidden" class="form-control" value="${requestScope["product"].getId()}" name="id">
            </div>
            <div class="mb-3">
                <label  class="form-label">Product Name</label>
                <input type="text" class="form-control" value="${requestScope["product"].getName()}" name="name">
            </div>
            <div class="mb-3">
                <label  class="form-label">Price</label>
                <input type="number" class="form-control" value="${requestScope["product"].getPrice()}" name="price">
            </div>
            <div class="mb-3">
                <label  class="form-label">Product Description</label>
                <input type="text" class="form-control" value="${requestScope["product"].getDescription()}" name="description">
            </div>
            <div class="mb-3">
                <label  class="form-label">Producer</label>
                <input type="text" class="form-control" value="${requestScope["product"].getProducer()}" name="producer">
            </div>

            <button type="submit" class="btn btn-primary">Edit</button>
        </form>

    </div>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>

</html>
