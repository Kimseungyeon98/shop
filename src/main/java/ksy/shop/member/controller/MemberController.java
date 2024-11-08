package ksy.shop.member.controller;

import jakarta.servlet.http.HttpSession;
import ksy.shop.member.service.MemberService;
import ksy.shop.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public String member(Model model, HttpSession session){

        MemberVO user = (MemberVO)session.getAttribute("user");
        if(user!=null){
            //회원 목록 보여주기
            List<MemberVO> memberList = memberService.getMemberList();
            model.addAttribute("memberList",memberList);
        }

        return "/member/list";
    }

    @GetMapping("/members/new")
    public String register(){

        return "/member/register";
    }
    @PostMapping("/members/new")
    public String register(MemberVO member){
        memberService.registerMember(member);
        return "redirect:/members";
    }

    @GetMapping("/members/logIn")
    public String logIn(){
        return "/member/login";
    }
    @PostMapping("/members/logIn")
    public String logIn(MemberVO member, HttpSession session){
        // 입력한 아이디로 member 객체 조회
        MemberVO user = memberService.getMemberById(member.getId());
        // 입력한 아이디로 조회한 member의 password와 입력한 password 비교
        if(user!=null && member.getPassword().equals(user.getPassword())){
            //로그인 성공
            session.setAttribute("user", user);
            return "redirect:/";
        } else {
            //로그인 실패
            return logIn();
        }
    }

    @GetMapping("/members/logOut")
    public String logOut(HttpSession session){
        MemberVO user = (MemberVO)session.getAttribute("user");
        if(user!=null){
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/members/myPage")
    public String myPage(){

        return "/member/myPage";
    }
}
