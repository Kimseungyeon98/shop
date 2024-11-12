package ksy.shop.order.service;

import ksy.shop.order.domain.OrderDTO;

import java.util.List;

public interface OrderService {
    // select(find)
    OrderDTO findOrderByNum(Long num);
    List<OrderDTO> findAllOrderByMember_Num(Long mem_num);

    // insert(save)
    OrderDTO saveOrder(OrderDTO order);

    // update(update)


    // delete(delete)
    void deleteOrderByNum(Long num);
}
