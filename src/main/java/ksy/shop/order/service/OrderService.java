package ksy.shop.order.service;

import ksy.shop.order.entity.OrderEntity;
import ksy.shop.order.vo.OrderVO;

public interface OrderService {
    // select(find)
    OrderVO findOrderByNum(Long num);
    OrderVO findOrderByMemNum(Long mem_num);

    // insert(save)
    void saveOrder(OrderVO order);

    // update(update)


    // delete(delete)
    void deleteOrderByNum(Long num);
}
