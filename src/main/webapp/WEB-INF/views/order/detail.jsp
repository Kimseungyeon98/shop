<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>주문 정보 상세 조회</title>
</head>
<body>
    <div>
        <h2>주문 정보 상세 조회</h2>
    </div>
    <div>
        <button onclick="location.href='/'">메인으로 가기</button>
        <button onclick="location.href='/items'">상품보러 가기</button>
    </div>
    <div>
        <ul>
            <li>주문 번호  : ${order.num}</li>
            <li>주문 일시  : ${order.reg_date}</li>
            <li>주문 총 금액  : ${order.total_price}</li>
            <li>주문 발송 상태  : ${order.status}</li>
            <li>주문 회원 이름  : ${order.member.name}</li>
            <li>주문 상품 이름  : ${order.item.name}</li>
        </ul>
    </div>
</body>
</html>