package ksy.shop.item.domain;

import jakarta.persistence.*;
import ksy.shop.member.domain.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ITEM")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq_gen")
    @SequenceGenerator(name = "item_seq_gen", sequenceName = "ITEM_SEQ", allocationSize = 1)
    private Long num;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = true)
    private String image;
    @Column(nullable = false)
    private String reg_date;
    @Column(nullable = false)
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mem_num", referencedColumnName = "num", nullable = false)
    private MemberEntity member;
}
