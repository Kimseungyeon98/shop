<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-08-24-0024
  Time: 오전 2:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html> 
    <head> 
        <meta charset="utf-8">
        <title>회원 목록</title>
    </head> 
    <body>
        <h1>회원목록</h1>
        <button onclick="history.back()">메인으로</button>
        <div>
            <c:if test="${!empty user}">
                ${user.name}님 환영합니다!
            </c:if>
        </div>
        <div>
            <a href="/member/register">회원가입
            <c:if test="${empty user}">
                <a href="/member/logIn">로그인</a>
            </c:if>
            <c:if test="${!empty user}">
                <a href="/member/logOut">로그아웃</a>
                <a href="/member/myPage">내 정보</a>
            </c:if>
        </div>
        <c:if test="${!empty user}">
            <div>
                <table>
                    <tr>
                        <th>이름</th><th>아이디</th><th>비밀번호</th>
                    <tr>
                    <c:forEach items="${memberList}" var="member">
                    <tr>
                        <td>${member.name}</td><td>${member.id}</td><td>${member.password}</td>
                    </tr>
                    </c:forEach>
                </table>
            <div>
        </c:if>
    </body>
</html>