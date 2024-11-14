package ksy.shop.order.domain;

import ksy.shop.item.domain.ItemDTO;
import ksy.shop.member.domain.MemberDTO;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    /*
     * 주문 번호 Long
     * 주문 상품 List<itemVO>
     * 주문 회원 MemberVO
     * 주문 일시 String
     * 주문 총 금액 Long
     * 주문 발송 상태 String
    */

    private Long num;
    private Date reg_date;
    private String status;
    private Long total_price;
    private MemberDTO member;
    private ItemDTO item;

    public static OrderDTO toDTO(OrderEntity orderEntity) {
        return new OrderDTO(orderEntity.getNum(), orderEntity.getReg_date(), orderEntity.getStatus(), orderEntity.getTotal_price(), MemberDTO.toDTO(orderEntity.getMember()), ItemDTO.toDTO(orderEntity.getItem()));
    }
    public static OrderEntity toEntity(OrderDTO orderDTO) {
        return new OrderEntity(orderDTO.getNum(), orderDTO.getReg_date(), orderDTO.getStatus(), orderDTO.getTotal_price(), MemberDTO.toEntity(orderDTO.getMember()), ItemDTO.toEntity(orderDTO.getItem()));
    }
}