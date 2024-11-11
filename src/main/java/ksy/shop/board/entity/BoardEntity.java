package ksy.shop.board.entity;

import jakarta.persistence.*;
import ksy.shop.member.entity.MemberEntity;

@Entity
@Table(name="BOARD")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_gen")
    @SequenceGenerator(name = "board_seq_gen", sequenceName = "BOARD_SEQ", allocationSize = 1)
    private Long num;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String reg_date;

    @ManyToOne
    @JoinColumn(name="mem_num",referencedColumnName = "num",nullable = false)
    private MemberEntity member;
}
