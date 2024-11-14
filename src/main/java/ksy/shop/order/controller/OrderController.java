package ksy.shop.order.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import ksy.shop.item.domain.ItemDTO;
import ksy.shop.item.service.ItemService;
import ksy.shop.member.domain.MemberDTO;
import ksy.shop.member.service.MemberService;
import ksy.shop.order.domain.OrderDTO;
import ksy.shop.order.domain.OrderEntity;
import ksy.shop.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private ItemService itemService;

    // 내 모든 주문 조회
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
    // 내 특정 주문 상세 조회
    @GetMapping("/orders/{num}")
    public String viewOrder(@PathVariable(name="num") Long order_num, HttpSession session, Model model) {
        MemberDTO user = (MemberDTO)session.getAttribute("user");
        if(user == null) {
            return "redirect:/members/login";
        } else {
            OrderDTO order = orderService.findOrderByNum(order_num);
            model.addAttribute("order", order);
            return "/order/detail";
        }
    }

    // 주문 등록
    @PostMapping("/orders/{num}")
    @ResponseBody
    public Map<String,String> createOrder(@PathVariable(name="num") Long item_num, HttpSession session) {
        Map<String,String> map = new HashMap<>();

        MemberDTO user = (MemberDTO)session.getAttribute("user");
        //로그인 처리 되어 있을 때만 주문 등록 가능
        if(user == null) {
            map.put("auth", "logout");
            map.put("url","members/logIn");
        } else {
            map.put("auth", "login");
            try{
                ItemDTO item = itemService.getItem(item_num);
                OrderDTO order = new OrderDTO(null,new Date(),"ready",item.getPrice()*item.getQuantity(),user,item);
                order = orderService.saveOrder(order);
                if(order!=null){
                    map.put("url","orders/"+order.getNum());
                    map.put("status", "success");
                } else {
                    map.put("url", "orders");
                    map.put("status", "fail-1");
                }
            } catch(Exception e){
                //무슨 에러가 발생할까?
                map.put("url","orders");
                map.put("status", "fail");
            }
        }
        return map;
    }

    // 주문 취소


}
