package ksy.shop.item.domain;

import ksy.shop.member.domain.MemberDTO;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item_CartDTO {
    private Long num;
    private MemberDTO member;
    private ItemDTO item;
    private String reg_date;
}
