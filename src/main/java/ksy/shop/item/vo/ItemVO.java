package ksy.shop.item.vo;

import ksy.shop.member.vo.MemberVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class ItemVO {
    private Long num;
    private String name;
    private String type;
    private String content;
    private Long price;
    private String image;
    private String reg_date;
    private Long quantity;
}
