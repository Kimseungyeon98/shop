package ksy.shop.order.service;

import ksy.shop.order.domain.OrderDTO;

public interface OrderService {
    // select(find)
    OrderDTO findOrderByNum(Long num);

    // insert(save)
    OrderDTO saveOrder(OrderDTO order);

    // update(update)


    // delete(delete)
    void deleteOrderByNum(Long num);
}
