<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-11-04-월요일
  Time: 오후 7:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>예약</title>
</head>
<body>
    <div>
        <h2>예약페이지</h2>
        <button onclick="reservation()" style="cursor:pointer;">예약 버튼</button>
    </div>
    <div>
        <h5>예약리스트</h5>
        <table>
            <tr>
                <th>예약 이름</th>
                <th>예약 내용</th>
                <th>예약 가격</th>
                <th>예약 시작 날짜</th>
                <th>예약 종료 날짜</th>
                <th>예약 회원 이름</th>
            </tr>
            <c:forEach items="${reservationList}" var="reservation">
                <tr>
                    <td>${reservation.name}</td>
                    <td>${reservation.content}</td>
                    <td>${reservation.price}</td>
                    <td>${reservation.start_date}</td>
                    <td>${reservation.end_date}</td>
                    <td>${reservation.member.name}</td>
                </tr>
            </c:forEach>
        </table>

    </div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<script>
    function reservation(){
        if('${user.num}' === null) {
            alert("임시 로그인 처리");
        } else {
            $.ajax({
                url: '/reservations',
                type: "POST",
                success: function(param){
                    alert(param.result);
                },
                error: function(){
                    alert("예약 에러 발생");
                }
            })
        }
    }
</script>
</html>