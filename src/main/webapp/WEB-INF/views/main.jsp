<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>메인</title>
</head>
<body>
    <div class="container-fluid p-5">
        <h1 class="text-center text-decoration-underline">메인페이지</h1>
        <c:if test="${!empty user}"><p>${user.id} 님 반갑습니다.</p></c:if>
        <div class="d-flex justify-content-around">
            <div class="p-3 fw-bold fs-5 border" style="cursor:pointer;" onclick="location.href='/member'">회원 카테고리</div>
            <div class="p-3 fw-bold fs-5 border" style="cursor:pointer;" onclick="location.href='/board'">게시판 카테고리</div>
            <div class="p-3 fw-bold fs-5 border" style="cursor:pointer;" onclick="location.href='/item'">상품 카테고리</div>
            <div class="p-3 fw-bold fs-5 border" style="cursor:pointer;" onclick="location.href='/reservations'">예약 카테고리</div>
        </div>
    </div>
</body>
</html>