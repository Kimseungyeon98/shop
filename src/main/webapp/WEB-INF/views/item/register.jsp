<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-09-01-0001
  Time: 오전 1:35
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html> 
    <head> 
        <meta charset="utf-8">
        <title>상품 등록</title>
    </head> 
    <body>
        <h1>상품 등록</h1>
        <div>
            <form action="/item/register" method="post">
                <label for="name">상품 이름
                <input type="text" name="name" id="name" required>
                <br>
                <label for="type">상품 종류
                <input type="text" name="type" id="type" required>
                <br>
                <label for="content">상품 내용
                <textarea rows="7" cols="15" name="content" id="content" required></textarea>
                <br>
                <label for="price">상품 가격
                <input type="number" name="price" id="price" required>
                <br>
                <label for="image">상품 이미지
                <input type="file" accept=".*" name="image" id="image">
                <br>
                <input type="submit" value="등록">
                <button onclick="history.back()">뒤로가기</button>
            </form>
        </div>
    </body>
</html>