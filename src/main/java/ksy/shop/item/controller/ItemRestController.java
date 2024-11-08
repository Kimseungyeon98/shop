package ksy.shop.item.controller;

import jakarta.servlet.http.HttpSession;
import ksy.shop.item.service.ItemService;
import ksy.shop.item.vo.ItemVO;
import ksy.shop.item.vo.Item_CartVO;
import ksy.shop.member.service.MemberService;
import ksy.shop.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/items/ItemCarts/new")
    public Map<String,String> registerItemCart(@RequestParam Long mem_num, @RequestParam Long item_num) {
        Map<String,String> map = new HashMap<>();

        Map<String,Long> vmap = new HashMap<>();
        vmap.put("mem_num",mem_num);
        vmap.put("item_num",item_num);
        Item_CartVO validation = itemService.getItem_Cart(vmap);
        if(validation==null){
            Item_CartVO item_cartVO = new Item_CartVO();

            ItemVO itemVO = itemService.getItem(item_num);
            item_cartVO.setItem(itemVO);

            MemberVO memberVO = memberService.getMember(mem_num);
            item_cartVO.setMember(memberVO);

            itemService.registerItem_cart(item_cartVO);

            map.put("success", "장바구니에 성공적으로 추가했습니다.");
        } else {
            map.put("fail", "이미 장바구니에 존재하는 상품입니다.");
        }

        return map;
    }

    @DeleteMapping("/items/ItemCarts")
    public Map<String,String> cancleItemCart(HttpSession session, @RequestParam Long itemNum) {
        Map<String,String> map = new HashMap<>();

        MemberVO user = (MemberVO) session.getAttribute("user");
        Long mem_num = user.getNum();
        try{
            itemService.cancleItem_Cart(mem_num,itemNum);
            map.put("success","success");
        } catch(Exception e){
            e.printStackTrace();
            map.put("fail","fail");
        }
        return map;
    }
}
