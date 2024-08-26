<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-08-26-0026
  Time: 오후 6:51
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html> 
    <head> 
        <meta charset="utf-8">
        <title>로그인</title>
    </head> 
    <body>
        <h1>로그인</h1>
        <form action="/member/logIn" method="post">
            <label for="id">아이디
            <input type="text" name="id" id="id">
            <label for="password">비밀번호
            <input type="password" name="password" id="password">
            <input type="submit" value="로그인">
        </form>
    </body>
</html>