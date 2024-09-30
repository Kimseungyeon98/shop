package ksy.shop.item.controller;

import jakarta.servlet.http.HttpSession;
import ksy.shop.item.service.ItemService;
import ksy.shop.item.vo.ItemVO;
import ksy.shop.item.vo.Item_CartVO;
import ksy.shop.member.service.MemberService;
import ksy.shop.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class ItemRestController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private MemberService memberService;

    @GetMapping("/item/registerItemCart")
    public Map<String,String> registerItemCart(@RequestParam Long mem_num, @RequestParam Long item_num) {
        Map<String,String> map = new HashMap<>();

        Item_CartVO item_cartVO = new Item_CartVO();

        ItemVO itemVO = itemService.getItem(item_num);
        item_cartVO.setItem(itemVO);

        MemberVO memberVO = memberService.getMember(mem_num);
        item_cartVO.setMember(memberVO);

        itemService.registerItem_cart(item_cartVO);

        map.put("success", "success");
        return map;
    }
}
