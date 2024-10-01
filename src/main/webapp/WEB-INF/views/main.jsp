<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>메인</title>
</head>
<body>
    <h1>메인페이지</h1>
    <c:if test="${!empty user}"><p>${user.id} 님 반갑습니다.</p></c:if>
    <div style="display:flex">
        <a href="/member">회원 카테고리</a>
        <a href="/board">게시판 카테고리</a>
        <a href="/item">상품 카테고리</a>
    </div>
</body>
</html>