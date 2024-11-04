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