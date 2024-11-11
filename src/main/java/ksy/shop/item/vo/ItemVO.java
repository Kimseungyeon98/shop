package ksy.shop.item.vo;

import ksy.shop.member.vo.MemberVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
@NoArgsConstructor
public class ItemVO {
    private Long num;
    private String name;
    private String type;
    private String content;
    private Long price;
    private String image;
    private String reg_date;
    private Long quantity;

    private MemberVO member;

    public ItemVO(Long num, String name, String type, String content, Long price, String image, String reg_date, Long quantity, MemberVO member) {
        this.num = num;
        this.name = name;
        this.type = type;
        this.content = content;
        this.price = price;
        this.image = image;
        this.reg_date = reg_date;
        this.quantity = quantity;
        this.member = member;
    }
}
