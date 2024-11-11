package ksy.shop.member.vo;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
@NoArgsConstructor
public class MemberVO {
    private Long num;
    private String name;
    private String id;
    private String password;

    public MemberVO(Long num, String name, String id, String password) {
        this.num = num;
        this.name = name;
        this.id = id;
        this.password = password;
    }
}
