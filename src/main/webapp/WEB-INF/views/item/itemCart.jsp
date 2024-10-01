<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-10-01-화요일
  Time: 오후 1:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>장바구니</title>
</head>
<body>
    <h1>장바구니</h1>
    <button onclick="history.back()">뒤로가기</button>
    <table>
        <tr>
            <th>상품 이름</th><th>상품 가격</th><th>장바구니 추가일</th>
        </tr>
        <c:forEach items="${item_CartList}" var="item_Cart">
            <tr>
                <td>${item_Cart.item.name}</td><td>${item_Cart.item.price}</td><td>${item_Cart.item.reg_date}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>