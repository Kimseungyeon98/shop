package ksy.shop.item.controller;

import jakarta.servlet.http.HttpSession;
import ksy.shop.item.service.ItemService;
import ksy.shop.item.vo.ItemVO;
import ksy.shop.item.vo.Item_CartVO;
import ksy.shop.member.vo.MemberVO;
import ksy.shop.util.PagingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@Slf4j
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/item")
    public String item(Model model, @RequestParam(defaultValue = "1") String currentPage, @RequestParam(defaultValue = "5") String itemNum){
        //페이징 처리
        Map<String,String> map = PagingUtil.paging(currentPage,itemNum);
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
    public String register(HttpSession session, ItemVO item, @RequestParam MultipartFile file) throws IOException {
        MemberVO user = (MemberVO)session.getAttribute("user");
        if(user==null){
            return "/member/login";
        } else {
            item.setMember(user);
        }
        if(!file.isEmpty()){
            // 파일 업로드 로직
            //1. 원본 파일 이름 가져오기
            String originalFilename = file.getOriginalFilename();
            //2. 확장자 앞 까지 파일 이름 인덱스 찾기
            int pos = originalFilename.lastIndexOf(".");
            //3. 확장자 저장
            String ext = originalFilename.substring(pos+1);
            //4. uuid 코드 생성
            String uuid = UUID.randomUUID().toString();
            //5. uuid 코드 + 확장자
            String storeFileName = uuid + "." + ext;

            // 파일 업로드 경로 설정
            String uploadDir = "src/main/resources/static/upload/";
            File uploadPath = new File(uploadDir);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();  // 디렉토리 생성
            }
            
            //File.separator 는 운영체제마다 다른 구분자를 자동 지정해줌
            file.transferTo(new File(uploadPath.getAbsolutePath() + File.separator + storeFileName));

            item.setImage(storeFileName);
        }

        itemService.registerItem(item);
        return "redirect:/item";
    }

    @GetMapping("/item/detail/{itemNum}")
    public String detail(@PathVariable("itemNum") Long itemNum, Model model){
        ItemVO item = itemService.getItem(itemNum);
        model.addAttribute("item", item);
        return "/item/detail";
    }

    @GetMapping("/item/itemCart")
    public String itemCart(HttpSession session, Model model){
        MemberVO user = (MemberVO)session.getAttribute("user");
        if(user != null){
            List<Item_CartVO> item_cartVOList = itemService.getItem_CartList(user.getNum());
            model.addAttribute("item_CartList", item_cartVOList);
        }

        return "/item/itemCart";
    }
}
