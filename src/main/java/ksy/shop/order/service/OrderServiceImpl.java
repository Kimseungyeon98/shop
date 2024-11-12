package ksy.shop.order.service;

import ksy.shop.order.domain.OrderEntity;
import ksy.shop.order.repository.OrderRepository;
import ksy.shop.order.domain.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderDTO findOrderByNum(Long num) {
        Optional<OrderEntity> op = orderRepository.findById(num);
        return op.map(OrderDTO::toDTO).orElse(null);
    }

    @Override
    public OrderDTO saveOrder(OrderDTO order) {
        return OrderDTO.toDTO(orderRepository.save(OrderDTO.toEntity(order)));
    }

    @Override
    public void deleteOrderByNum(Long num) {
        orderRepository.deleteById(num);
    }
}
