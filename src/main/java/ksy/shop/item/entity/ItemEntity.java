package ksy.shop.item.entity;

import jakarta.persistence.*;
import ksy.shop.member.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ITEM")
@Getter
@NoArgsConstructor
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

    public ItemEntity(Long num, String name, String type, String content, Long price, String image, String reg_date, Long quantity, MemberEntity member) {
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
