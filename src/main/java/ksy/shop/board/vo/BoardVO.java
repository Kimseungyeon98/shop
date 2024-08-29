package ksy.shop.board.vo;

import ksy.shop.member.vo.MemberVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class BoardVO {
    private Long num;
    private String title;
    private String content;
    private String reg_date;

    private MemberVO member;
}
