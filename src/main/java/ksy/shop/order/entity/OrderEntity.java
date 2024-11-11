package ksy.shop.order.entity;

import jakarta.persistence.*;
import ksy.shop.item.entity.ItemEntity;
import ksy.shop.item.vo.ItemVO;
import ksy.shop.member.entity.MemberEntity;
import ksy.shop.member.vo.MemberVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name="mem_num",referencedColumnName = "num",nullable = true)
    private MemberEntity member;
    @ManyToOne
    @JoinColumn(name="item_num",referencedColumnName = "num",nullable = true)
    private ItemEntity item;
}