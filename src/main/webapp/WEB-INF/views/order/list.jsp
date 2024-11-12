<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>내 주문 정보</title>
</head>
<body>
<div>
    <h2>내 주문 정보 목록</h2>
</div>
<div>
    <c:if test="${!empty orderList}">
    <table>
        <tr>
            <th>주문 번호</th>
            <th>주문 날짜</th>
            <th>주문 총 금액</th>
            <th>주문 상태</th>
            <th>회원 이름</th>
            <th>상품 이름</th>
        </tr>
        <c:forEach items="${orderList}" var="order">
            <tr>
                <td>${order.num}</td>
                <td>${order.reg_date}</td>
                <td>${order.status}</td>
                <td>${order.total_price}</td>
                <td>${order.member.name}</td>
                <td>${order.item.name}</td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
    <c:if test="${empty orderList}">
        <p>주문 정보 없음</p>
        <a href='/items'>지금 주문하러 가기!</a>
    </c:if>
</div>
</body>
</html>