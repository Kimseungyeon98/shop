package ksy.shop.order.domain;

import jakarta.persistence.*;
import ksy.shop.item.domain.ItemEntity;
import ksy.shop.member.domain.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ORDERS")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq_gen")
    @SequenceGenerator(name = "orders_seq_gen", sequenceName = "ORDERS_SEQ", allocationSize = 1)
    private Long num;

    @Column(nullable = false)
    private String reg_date;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private Long total_price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mem_num",referencedColumnName = "num",nullable = true)
    private MemberEntity member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_num",referencedColumnName = "num",nullable = true)
    private ItemEntity item;
}