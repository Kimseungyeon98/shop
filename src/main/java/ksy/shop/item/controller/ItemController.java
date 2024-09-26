package ksy.shop.item.controller;

import jakarta.servlet.http.HttpSession;
import ksy.shop.item.service.ItemService;
import ksy.shop.item.vo.ItemVO;
import ksy.shop.member.vo.MemberVO;
import ksy.shop.util.PagingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/item")
    public String item(Model model, @RequestParam(defaultValue = "1") String currentPage, @RequestParam(defaultValue = "5") String itemNum){
        //페이징 처리
        Map<String,String> map = PagingUtil.paging(currentPage,itemNum);
        System.out.println(map);
        List<ItemVO> itemList = itemService.getItemList(map);
        int totalCount = itemService.getItemCount();

        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("itemNum", itemNum);
        model.addAttribute("itemList", itemList);
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
            itemService.registerItem(item);
        }
        return "/item/list";
    }
}
