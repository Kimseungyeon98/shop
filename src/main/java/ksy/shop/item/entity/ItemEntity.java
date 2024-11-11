package ksy.shop.item.entity;

import jakarta.persistence.*;
import ksy.shop.member.entity.MemberEntity;

@Entity
@Table(name="ITEM")
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

    @ManyToOne
    @JoinColumn(name="mem_num", referencedColumnName = "num", nullable = false)
    private MemberEntity member;
}
