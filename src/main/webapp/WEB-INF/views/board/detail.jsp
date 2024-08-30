<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-08-30-0030
  Time: 오후 8:47
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html> 
    <head> 
        <meta charset="utf-8">
        <title>글 상세</title>
    </head> 
    <body>
        <h1>글 상세</h1>
        <button onclick="history.back()">뒤로가기</button>
        <div>
            ${board.title}<br>
            ${board.member.name} / ${board.reg_date}<br>
            ${board.content}<br>
        </div>
    </body>
</html>