package ksy.shop.order.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import ksy.shop.member.domain.MemberDTO;
import ksy.shop.order.domain.OrderDTO;
import ksy.shop.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    // 내 주문 조회
    @GetMapping("/orders")
    public String viewOrder(HttpSession session, Model model) {
        MemberDTO user = (MemberDTO)session.getAttribute("user");
        if(user == null) {
            return "redirect:/members/login";
        } else {
            List<OrderDTO> orderList = orderService.findAllOrderByMember_Num(user.getNum());
            model.addAttribute("orderList", orderList);
            return "/order/list";
        }
    }

    // 주문 등록


    // 주문 취소


}
