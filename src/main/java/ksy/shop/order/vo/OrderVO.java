package ksy.shop.order.vo;

import ksy.shop.item.vo.ItemVO;
import ksy.shop.member.vo.MemberVO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderVO {
    /*
     * 주문 번호 Long
     * 주문 상품 List<itemVO>
     * 주문 회원 MemberVO
     * 주문 일시 String
     * 주문 총 금액 Long
     * 주문 발송 상태 String
    */

    private Long num;
    private String reg_date;
    private String status;
    private Long total_price;
    private MemberVO member;
    private ItemVO item;

    public OrderVO(Long num, String reg_date, String status, Long total_price, MemberVO member, ItemVO item) {
        this.num = num;
        this.reg_date = reg_date;
        this.status = status;
        this.total_price = total_price;
        this.member = member;
        this.item = item;
    }
}