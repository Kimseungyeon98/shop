package ksy.shop.orderItem.domain;

import jakarta.persistence.*;
import ksy.shop.item.domain.ItemEntity;
import ksy.shop.member.domain.MemberEntity;
import lombok.*;

@Entity
@Table(name="ORDERS_ITEM")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_num",referencedColumnName = "num")
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_num",referencedColumnName = "num")
    private ItemEntity item;
}