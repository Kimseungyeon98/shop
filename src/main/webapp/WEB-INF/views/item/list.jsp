<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-09-01-0001
  Time: 오전 1:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html> 
    <head> 
        <meta charset="utf-8">
        <title>상품 목록</title>
    </head> 
    <body>
        <h1>상품 목록</h1>
        <c:if test="${!empty user}"><button onclick="location.href='/item/register'">상품 등록</button></c:if>
        <div>
            <table>
                <tr>
                    <th>등록자 이름</th><th>상품 이름</th><th>상품 종류</th><th>상품 내용</th><th>상품 가격</th><th>상품 등록일</th><th>상품 수량</th>
                </tr>
                <c:forEach items="${itemList}" var="item">
                <tr>
                    <td>${item.member.name}</td><td>${item.name}</td><td>${item.type}</td><td>${item.content}</td><td>${item.price}</td><td>${item.reg_date}</td><td>${item.quantity}</td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <button onclick="history.back()">뒤로가기</button>
    </body>
</html>