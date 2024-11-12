package ksy.shop.reservation.domain;

import ksy.shop.member.domain.MemberDTO;
import lombok.*;

@Getter@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private Long num;
    private String name;
    private String content;
    private String start_date;
    private String end_date;
    private String price;

    private MemberDTO member;
}
