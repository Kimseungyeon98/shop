package ksy.shop.order.service;

import jakarta.persistence.EntityManager;
import ksy.shop.item.dao.ItemMapper;
import ksy.shop.item.domain.ItemEntity;
import ksy.shop.item.domain.ItemDTO;
import ksy.shop.member.dao.MemberMapper;
import ksy.shop.member.domain.MemberEntity;
import ksy.shop.member.domain.MemberDTO;
import ksy.shop.order.domain.OrderDTO;
import ksy.shop.order.domain.OrderEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    EntityManager em;


    @Test
    @DisplayName("주문 로직 테스트")
    void saveOrder() {
        //given&when : 21번 회원이 1번 아이템을 주문했다.
        MemberDTO member = memberMapper.selectMember(21l);
        ItemDTO item = itemMapper.selectItem(1l);

        System.out.println("--------------------------------------------------------");
        System.out.println("----------------------- 주문 전 정보 -------------------------");
        System.out.println("member: " + member.toString());
        System.out.println("item: " + item.toString());
        System.out.println("--------------------------------------------------------");

        // 1. itemVO를 itemEntity로
        ItemEntity itemEntity = ItemDTO.toEntity(item);

        // 2. memberVO를 memberEntity로
        MemberEntity memberEntity = MemberDTO.toEntity(member);

        // 3. orderEntity 생성
        OrderEntity orderEntity = new OrderEntity(null,"2024-11-11","READY",item.getPrice()*item.getQuantity(),memberEntity,itemEntity);

        // 4. save하기
        OrderDTO saveOrder = orderService.saveOrder(OrderDTO.toDTO(orderEntity));

        // 5. find하기
        System.out.println("우리가 찾을 주문의 num: " + saveOrder.getNum());
        OrderDTO findOrder = orderService.findOrderByNum(saveOrder.getNum());

        //that : 주문한 정보와 주문 저장 정보가 같나?
        System.out.println("-----------------------------------------");
        System.out.println("주문한 정보: " + saveOrder.toString());
        System.out.println("저장된 정보: " + findOrder.toString());
        System.out.println("-----------------------------------------");
        Assertions.assertThat(saveOrder.getTotal_price()).isEqualTo(findOrder.getTotal_price());
    }

    @Test
    @DisplayName("findByMemNum 메서드 테스트")
    void findByMemNum() {
        //given
        MemberDTO member = memberMapper.selectMember(1l);
        ItemDTO item = itemMapper.selectItem(3l);
        OrderDTO order = new OrderDTO(1000l,"2024-11-11","READY",item.getPrice()*item.getQuantity(),member,item);

        //when
        // 1. 3번 상품 주문 정보 저장
        orderService.saveOrder(order);
        // 2. 4번 상품 주문 정보 저장
        item = itemMapper.selectItem(4l);
        order.setItem(item);
        orderService.saveOrder(order);

        List<OrderDTO> orderList = orderService.findAllOrderByMember_Num(member.getNum());
        //then
        // 3. 회원 정보로 모든 주문 정보 조회
        Assertions.assertThat(orderList.size()).isEqualTo(2);

    }
}