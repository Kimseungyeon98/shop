package ksy.shop.order.service;

import ksy.shop.item.entity.ItemEntity;
import ksy.shop.item.vo.ItemVO;
import ksy.shop.member.entity.MemberEntity;
import ksy.shop.member.vo.MemberVO;
import ksy.shop.order.entity.OrderEntity;
import ksy.shop.order.repository.OrderRepository;
import ksy.shop.order.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderVO findOrderByNum(Long num) {
        OrderEntity orderEntity = orderRepository.findById(num).get();

        MemberEntity memberEntity = orderEntity.getMember();
        MemberVO memberVO = new MemberVO(memberEntity.getNum(),memberEntity.getName(),memberEntity.getId(),memberEntity.getPassword());

        ItemEntity itemEntity = orderEntity.getItem();
        MemberEntity registerEntity = itemEntity.getMember();
        MemberVO register = new MemberVO(registerEntity.getNum(),registerEntity.getName(),registerEntity.getId(),registerEntity.getPassword());
        ItemVO item = new ItemVO(itemEntity.getNum(),itemEntity.getName(),itemEntity.getType(),itemEntity.getContent(),itemEntity.getPrice(),itemEntity.getImage(),itemEntity.getReg_date(),itemEntity.getQuantity(), register);

        OrderVO orderVO = new OrderVO(orderEntity.getNum(),orderEntity.getReg_date(),orderEntity.getStatus(),orderEntity.getTotal_price(), memberVO,item);
        return orderVO;
    }

    @Override
    public OrderVO findOrderByMemNum(Long mem_num) {
        return null;
    }

    @Override
    public void saveOrder(OrderVO order) {
    }

    @Override
    public void deleteOrderByNum(Long num) {

    }
}
