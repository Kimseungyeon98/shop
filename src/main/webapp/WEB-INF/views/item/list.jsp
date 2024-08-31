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
            아이템 목록
        </div>
        <button onclick="history.back()">뒤로가기</button>
    </body>
</html>