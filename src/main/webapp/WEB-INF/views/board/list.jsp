<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-08-29-0029
  Time: 오후 3:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html> 
    <head> 
        <meta charset="utf-8">
        <title>게시판 목록</title>
    </head> 
    <body>
        <h1>게시판 목록</h1>
        <button onclick="history.back()">메인으로</button>
        <div>
            <c:if test="${!empty user}">
            <a href="/board/register">글 쓰기</a>
            </c:if>
            <c:if test="${empty user}">
            <a href="/member/logIn">로그인</a>
            </c:if>
        </div>
        <c:if test="${empty boardList}">
            등록된 글이 없습니다!
        </c:if>
        <c:if test="${!empty boardList}">
        <table>
            <tr>
                <th>제목</th><th>작성자</th><th>내용</th><th>작성일</th>
            </tr>
            <c:forEach items="${boardList}" var="board">
            <tr>
                <td><a href="/board/detail/${board.num}">${board.title}</a></td><td>${board.member.name}</td><td>${board.content}</td><td>${board.reg_date}</td>
            </tr>
            </c:forEach>
        </table>
        </c:if>
    </body>
</html>