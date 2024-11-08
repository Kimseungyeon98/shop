<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-09-27-금요일
  Time: 오후 1:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
    <title>상품 상세</title>
</head>
<body>
    <h1>상품 상세</h1>
    <button onclick="location.href='/items'">뒤로가기</button>
    <div>
        <ul style="list-style:none;">
            <li>상품명: ${item.name}</li>
            <li>상품종류: ${item.type}</li>
            <li>상품가격: ${item.price}원</li>
            <c:if test="${!empty item.image}">
                <li>상품 사진: <img src="/upload/${item.image}" alt="상품 이미지" height="200px" width="300px"></li>
            </c:if>
            <li>상품 등록일: ${item.reg_date}</li>
            <li>상품 수량: ${item.quantity}</li>
            <li>상품 설명: ${item.content}</li>
            <li>상품 등록자: ${item.member.id}</li>
        </ul>
    </div>
    <div>
        <button onclick="validationUser('${user.id}')">상품 구매</button>
        <button onclick="registerItemCart('${user.num}','${item.num}')">장바구니 담기</button>
    </div>
</body>
<script>
    function validationUser(user_id){
        if(!user_id){
            if(confirm("상품을 구매하시려면 로그인을 해주세요")){
                location.href = '/members/logIn';
            }
        } else {
            location.href = '/items/buy';
        }
    }

    function registerItemCart(mem_num, item_num) {
        if(!mem_num){
            if(confirm("상품을 장바구니에 추가하시려면 로그인을 해주세요")){
                location.href = '/members/logIn';
            }
        } else {
            $.ajax({
                url: "/items/ItemCarts/new",
                type: "GET",
                dataType: "json",
                data: {mem_num: mem_num, item_num: item_num},
                success: function(param){
                    if(param.success){
                        alert(param.success);
                    } else if(param.fail){
                        alert(param.fail);
                    }
                },
                error: function(){
                    alert('실패?');
                }
            })
        }
    }

</script>
</html>