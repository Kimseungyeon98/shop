package ksy.shop.item.vo;

import ksy.shop.member.vo.MemberVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Item_CartVO {
    private Long num;
    private MemberVO member;
    private ItemVO item;
    private String reg_date;
}
