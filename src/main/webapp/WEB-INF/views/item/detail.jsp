<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-09-27-금요일
  Time: 오후 1:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>웹페이지 제목</title>
</head>
<body>
    <h1>상품 상세</h1>
    <button onclick="history.back()">뒤로가기</button>
    <div>
        ${item.name}<br>
        ${item.type}<br>
        ${item.price}<br>
        ${item.image}<br>
        ${item.reg_date}<br>
        ${item.quantity}<br>
        ${item.content}<br>
        ${item.member.id}<br>
    </div>
</body>
</html>