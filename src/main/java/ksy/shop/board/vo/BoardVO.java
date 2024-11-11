package ksy.shop.board.vo;

import ksy.shop.member.vo.MemberVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
@NoArgsConstructor
public class BoardVO {
    private Long num;
    private String title;
    private String content;
    private String reg_date;

    private MemberVO member;

    public BoardVO(Long num, String title, String content, String reg_date, MemberVO member) {
        this.num = num;
        this.title = title;
        this.content = content;
        this.reg_date = reg_date;
        this.member = member;
    }
}
