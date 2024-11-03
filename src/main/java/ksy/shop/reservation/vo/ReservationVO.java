package ksy.shop.reservation.vo;

import ksy.shop.member.vo.MemberVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class ReservationVO {
    private Long num;
    private String name;
    private String content;
    private String start_date;
    private String end_date;
    private String price;

    private Long mem_num;
}
