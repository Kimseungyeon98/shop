package ksy.shop.member.entity;

import jakarta.persistence.*;

@Entity
@Table(name="MEMBER")
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
}
