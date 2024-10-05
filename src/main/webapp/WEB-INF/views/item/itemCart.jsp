<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-10-01-화요일
  Time: 오후 1:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>장바구니</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
</head>
<body>
    <h1>장바구니</h1>
    <button onclick="history.back()">뒤로가기</button>
    <table>
        <tr>
            <th>선택</th><th>상품 이름</th><th>상품 가격</th><th>장바구니 추가일</th>
        </tr>
        <c:forEach items="${item_CartList}" var="item_Cart">
            <tr>
                <td><input type="checkbox" value="${item_Cart.item.price}" class="checkBox"></td><td>${item_Cart.item.name}</td><td>${item_Cart.item.price}</td><td>${item_Cart.item.reg_date}</td><td><button onclick="cancle('${item_Cart.item.num}')">삭제</button></td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <div>
            총 가격: <span id="total_price"></span>
        </div>
    </div>
</body>
<script>
    function cancle(itemNum){
        $.ajax({
            url: '/item/cancleItemCart',
            type: 'GET',
            data: {itemNum: itemNum},
            dataType: 'JSON',
            success: function(result){
                if(result.success=='success'){
                    alert('성공적으로 장바구니에서 \'삭제\'했습니다.');
                }else {
                    alert('잠시 후 다시 시도해주세요!');
                }
                location.reload(true);
            },
            error: function(){
                alert('서버 오류입니다. 다시 시도해주세요.');
            }
        })
    }
    var total_price = 0;
    $('.checkBox').change(function() {
        var price = parseInt($(this).val());

        // 체크가 되었을 경우 총 가격에 추가
        if ($(this).is(':checked')) {
            total_price += price;
        }
        // 체크가 해제되었을 경우 총 가격에서 해당 가격을 뺌
        else {
            total_price -= price;
        }

        // 총 가격을 업데이트
        $('#total_price').text(total_price + '원');
    });
</script>
</html>