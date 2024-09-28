<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-08-29-0029
  Time: 오후 3:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html> 
    <head> 
        <meta charset="utf-8">
        <title>글 쓰기</title>
    </head> 
    <body>
        <h1>글 쓰기</h1>
        <form action="/board/register" method="post">
            <label for="title">제목
            <input type="text" name="title" id="title" required>
            <br>
            <label for="content">내용
            <textarea rows="7" cols="20" name="content" id="content" required></textarea>
            <input type="submit" value="등록">
            <button onclick="history.back()">뒤로가기</button>
        </form>
    </body>
</html>