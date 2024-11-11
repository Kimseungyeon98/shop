package ksy.shop.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="MEMBER")
@Getter
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
    @SequenceGenerator(name = "member_seq_gen", sequenceName = "MEMBER_SEQ", allocationSize = 1)
    private Long num;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String password;

    public MemberEntity(Long num, String name, String id, String password) {
        this.num = num;
        this.name = name;
        this.id = id;
        this.password = password;
    }
}
