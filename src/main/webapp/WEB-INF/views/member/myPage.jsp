<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-08-29-0029
  Time: 오후 3:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html> 
    <head> 
        <meta charset="utf-8">
        <title>내 정보</title>
    </head> 
    <body>
        <h1>내 정보</h1>
        <div>
            이름: ${user.name}<br>
            아이디: ${user.id}<br>
            비밀번호: ${fn:substring(user.password,0,3)}
            <c:forEach var="i" begin="4" end="${fn:length(user.password)}">
                *
            </c:forEach>
        </div>
        <button onclick="history.back()">뒤로가기</button>
    </body>
</html>