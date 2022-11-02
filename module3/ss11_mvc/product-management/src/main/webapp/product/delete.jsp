
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Xoá Sản Phẩm</title>
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
        <form method="post">
            <h3>Are you sure?</h3>
            <fieldset>
                <legend>Product information</legend>
                <table>
                    <tr>
                        <td>Name:</td>
                        <td>${requestScope["product"].getName()}</td>
                    </tr>
                    <tr>
                        <td>Price:</td>
                        <td>${requestScope["product"].getPrice()}</td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td>${requestScope["product"].getDescription()}</td>
                    </tr>
                    <tr>
                        <td>Producer:</td>
                        <td>${requestScope["product"].getProducer()}</td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Delete Product"></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</div>

<%--Footer--%>
<%@include file="includes/footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>

</html>
