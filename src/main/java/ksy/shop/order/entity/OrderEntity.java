package ksy.shop.order.entity;

import jakarta.persistence.*;
import ksy.shop.item.entity.ItemEntity;
import ksy.shop.item.vo.ItemVO;
import ksy.shop.member.entity.MemberEntity;
import ksy.shop.member.vo.MemberVO;

import java.util.List;

@Entity
@Table(name="ORDER")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
    @SequenceGenerator(name = "order_seq_gen", sequenceName = "ORDER_SEQ", allocationSize = 1)
    private Long num;

    @Column(nullable = false)
    private String reg_date;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private Long total_price;

    @ManyToOne
    @JoinColumn(name="mem_num",referencedColumnName = "num",nullable = false)
    private MemberEntity member;
    @ManyToMany
    @JoinTable(name="order_item", joinColumns = @JoinColumn(name="num"), inverseJoinColumns = @JoinColumn(name="order_num"))
    private List<ItemEntity> item;
}
