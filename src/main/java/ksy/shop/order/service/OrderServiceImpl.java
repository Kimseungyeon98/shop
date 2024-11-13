package ksy.shop.order.service;

import ksy.shop.item.dao.ItemMapper;
import ksy.shop.item.domain.ItemDTO;
import ksy.shop.item.service.ItemService;
import ksy.shop.order.domain.OrderEntity;
import ksy.shop.order.repository.OrderRepository;
import ksy.shop.order.domain.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemMapper itemMapper;

    @Override
    public OrderDTO findOrderByNum(Long num) {
        Optional<OrderEntity> op = orderRepository.findById(num);
        return op.map(OrderDTO::toDTO).orElse(null);
    }

    @Override
    public List<OrderDTO> findAllOrderByMember_Num(Long mem_num) {
        List<OrderEntity> entityList = orderRepository.findByMember_num(mem_num);
        return entityList.stream().map(OrderDTO::toDTO).toList();
    }

    @Override
    public OrderDTO saveOrder(OrderDTO order){
        // 수량이 0보다 크다면? -> 주문 가능
        if(order.getItem().getQuantity() > 0){
            // 1. 주문을 한다.
            OrderEntity orderEntity = orderRepository.save(OrderDTO.toEntity(order));
            // 2. 주문 상품의 재고수량이 하나 줄어든다.
            ItemDTO item = ItemDTO.toDTO(orderEntity.getItem());

            item.setQuantity(item.getQuantity() - 1);
            itemMapper.updateQuantityItem(item);
            OrderDTO newOrder = OrderDTO.toDTO(orderEntity);
            newOrder.setItem(item);

            return newOrder;
        } else { //수량이 0 이하라면?
            // 사실 여기서 에러를 던지고 그걸 캐치해서 주문재고가 없다는걸 알아채야 한다.
            // 추후에 추가할 예정 일단 null이 반환되면 주문 에러로 가정하겠음.
            return null;
        }
    }

    @Override
    public void deleteOrderByNum(Long num) {
        orderRepository.deleteById(num);
    }
}
