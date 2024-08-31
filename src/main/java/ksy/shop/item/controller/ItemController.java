package ksy.shop.item.controller;

import jakarta.servlet.http.HttpSession;
import ksy.shop.item.service.ItemService;
import ksy.shop.item.vo.ItemVO;
import ksy.shop.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/item")
    public String item(Model model){

        return "/item/list";
    }

    @GetMapping("/item/register")
    public String register(HttpSession session){
        MemberVO user = (MemberVO)session.getAttribute("user");
        if(user==null){
            return "/member/login";
        }
        return "/item/register";
    }
    @PostMapping("/item/register")
    public String register(HttpSession session, ItemVO item){
        MemberVO user = (MemberVO)session.getAttribute("user");
        if(user==null){
            return "/member/login";
        } else {
            item.setMember(user);
            System.out.println(item);
            itemService.registerItem(item);
        }
        return "/item/list";
    }
}
