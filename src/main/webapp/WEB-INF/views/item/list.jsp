<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2024-09-01-0001
  Time: 오전 1:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html> 
    <head> 
        <meta charset="utf-8">
        <title>상품 목록</title>
    </head> 
    <body>
        <h1>상품 목록</h1>
        <c:if test="${!empty user}">
            <button onclick="location.href='/items/new'">상품 등록</button>
            <button onclick="location.href='/items/itemCarts'">내 장바구니</button>
        </c:if>
        <div>
            <table>
                <tr>
                    <th>등록자 이름</th>
                    <th>상품 이름</th>
                    <th>상품 이미지</th>
                    <th>상품 종류</th>
                    <th>상품 내용</th>
                    <th>상품 가격</th>
                    <th>상품 등록일</th>
                    <th>상품 수량</th>
                    <th>주문버튼</th>
                </tr>
                <c:forEach items="${itemList}" var="item">
                <tr>
                    <td>${item.member.name}</td>
                    <td><a href="/items/${item.num}">${item.name}</a></td>
                    <td>
                        <c:if test="${!empty item.image}">
                            <img src="/upload/${item.image}" alt="상품 이미지" height="50px" width="50px">
                        </c:if>
                        <c:if test="${empty item.image}">
                            <img src="/upload/noImage.png" alt="상품 이미지" height="50px" width="50px">
                        </c:if>
                    </td>
                    <td>${item.type}</td>
                    <td>${item.content}</td>
                    <td>${item.price}</td>
                    <td>${item.reg_date}</td>
                    <td>${item.quantity}</td>
                    <td><button onclick="order('${item.num}')">주문하기</button></td>
                </tr>
                </c:forEach>
            </table>
            <div style="display:flex">
                <c:if test="${currentPage>=2}">
                    <a href="/item?currentPage=${currentPage-1}">이전</a>
                </c:if>
                <c:if test="${currentPage*itemNum<totalCount}">
                    <a href="/item?currentPage=${currentPage+1}">다음</a>
                </c:if>
            </div>
        </div>
        <button onclick="location.href='/'">뒤로가기</button>
    </body>
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
    <script>
        function order(itemNum){
            if(confirm('주문하시겠습니까?')){
                $.ajax({
                    url: '/orders/'+itemNum,
                    type: 'POST',
                    dataType: 'JSON',
                    success: function(map){
                        if(map.auth==='login'){
                            if(map.status==='success'){
                                alert('주문이 완료되었습니다.');
                            } else if(map.status==='fail-1'){
                                alert('주문 실패했습니다. 재고 확인 후 다시 주문해주세요.');
                            } else if(map.status==='fail'){
                                alert('주문 실패했습니다. 알 수 없는 에러입니다.');
                            }
                        }
                        location.href = map.url;
                    },
                    error: function(){
                        alert('서버 오류입니다. 다시 시도해주세요.')
                    }
                })
            }
        }
    </script>
</html>