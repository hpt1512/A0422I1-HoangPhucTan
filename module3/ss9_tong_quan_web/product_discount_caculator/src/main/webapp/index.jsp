<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
    <title>Simple Dictionary</title>
    <style>
        input {
            display: block;
            padding: 10px 10px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h2>PRODUCT DISCOUNT CACULATOR</h2>
<form action="/product_discount" method="post">
    <input type="text" name="product_description" placeholder="Mô tả của sản phẩm: "/>
    <input type="number" name="list_price" placeholder="Giá niêm yết của sản phẩm: "/>
    <input type="number" name="discount_percent" placeholder="Tỷ lệ chiết khấu (%): "/>
    <input type = "submit" id = "submit" value = "Tính chiết khấu"/>
</form>
</body>
</html>