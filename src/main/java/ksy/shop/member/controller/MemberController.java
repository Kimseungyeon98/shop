package ksy.shop.member.controller;

import jakarta.servlet.http.HttpSession;
import ksy.shop.member.service.MemberService;
import ksy.shop.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/member")
    public String member(){

        return "/member/list";
    }

    @GetMapping("/member/register")
    public String register(){

        return "/member/register";
    }
    @PostMapping("/member/register")
    public String register(MemberVO member){
        memberService.insertMember(member);
        return "redirect:/member";
    }

    @GetMapping("/member/logIn")
    public String logIn(){
        return "/member/login";
    }
    @PostMapping("/member/logIn")
    public String logIn(MemberVO member, HttpSession session){
        // 입력한 아이디로 member 객체 조회
        MemberVO user = memberService.selectMemberById(member.getId());
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

    @GetMapping("/member/logOut")
    public String logOut(HttpSession session){
        MemberVO user = (MemberVO)session.getAttribute("user");
        if(user!=null){
            session.invalidate();
        }
        return "redirect:/";
    }
}
