package ksy.shop.board.domain;

import jakarta.persistence.*;
import ksy.shop.member.domain.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="BOARD")
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
