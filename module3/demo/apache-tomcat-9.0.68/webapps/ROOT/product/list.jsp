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
    <title>Trang Danh Sách Sản Phẩm</title>
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
                        <a href="/products?action=view&id=${product.getId()}"><button type="button" class="btn btn-success ">View</button></a>
                        <a href="/products?action=edit&id=${product.getId()}"><button type="button" class="btn btn-success ">Edit</button></a>
                        <a href="/products?action=delete&id=${product.getId()}"><button type="button" class="btn btn-success ">Delete</button></a>
                    </div>
                </li>
            </c:forEach>

        </ul>
        
        <ul class="pitch__list__content__nav">
            <c:forEach items='${requestScope["resustFindList"]}' var="product">
                <li class="pitch__list__content__nav__item">
                    <div class="pitch__list__content__nav__item__info">
                        <span class="name__pitch">${product.getName()}</span>
                        <span style="color: red" class="">${product.getPrice()}</span>
                        <span class="">${product.getDescription()}</span>
                        <span class="">${product.getProducer()}</span>
                    </div>
                    <div class="btn__div" style="position: absolute; right: 10px">
                        <a href="/products?action=view&id=${product.getId()}"><button type="button" class="btn btn-success ">View</button></a>
                        <a href="/products?action=edit&id=${product.getId()}"><button type="button" class="btn btn-success ">Edit</button></a>
                        <a href="/products?action=delete&id=${product.getId()}"><button type="button" class="btn btn-success ">Delete</button></a>
                    </div>
                </li>
            </c:forEach>

        </ul>

    </div>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>

</html>
