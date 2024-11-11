package ksy.shop.order.service;

import ksy.shop.item.dao.ItemMapper;
import ksy.shop.item.entity.ItemEntity;
import ksy.shop.item.vo.ItemVO;
import ksy.shop.member.dao.MemberMapper;
import ksy.shop.member.entity.MemberEntity;
import ksy.shop.member.vo.MemberVO;
import ksy.shop.order.entity.OrderEntity;
import ksy.shop.order.repository.OrderRepository;
import ksy.shop.order.vo.OrderVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    ItemMapper itemMapper;

    @Test
    @DisplayName("주문 로직 테스트")
    void saveOrder() {
        MemberVO member = memberMapper.selectMember(21l);
        ItemVO item = itemMapper.selectItem(1l);

        System.out.println("member: " + member.toString());
        System.out.println("item: " + item.toString());

        // 1. itemVO를 itemEntity로
        MemberVO register = item.getMember();
        MemberEntity registerEntity = new MemberEntity(register.getNum(),register.getName(),register.getId(),register.getPassword());
        ItemEntity itemEntity = new ItemEntity(item.getNum(),item.getName(),item.getType(),item.getContent(),item.getPrice(),item.getImage(),item.getReg_date(),item.getQuantity(), registerEntity);

        // 2. memberVO를 memberEntity로
        MemberEntity memberEntity = new MemberEntity(member.getNum(),member.getName(),member.getId(),member.getPassword());

        // 3. orderEntity 생성
        OrderEntity orderEntity = new OrderEntity(1000l,"2024-11-11","READY",item.getPrice()*item.getQuantity(),memberEntity,itemEntity);

        // 4. save하기
        OrderEntity orderEntity1 = orderRepository.save(orderEntity);

        Assertions.assertThat(orderEntity1.getClass()).isEqualTo(orderEntity.getClass());
    }
}