package ksy.shop.board.controller;

import jakarta.servlet.http.HttpSession;
import ksy.shop.board.service.BoardService;
import ksy.shop.board.vo.BoardVO;
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
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public String board(Model model){
        List<BoardVO> boardList = boardService.selectBoardList();
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }

    @GetMapping("/board/register")
    public String register(HttpSession session){
        MemberVO user = (MemberVO)session.getAttribute("user");
        if(user != null){
            return "/board/register";
        } else {
            return "/member/login";
        }
    }
    @PostMapping("/board/register")
    public String register(BoardVO board, HttpSession session){
        MemberVO user = (MemberVO)session.getAttribute("user");
        board.setMember(user);

        boardService.registerBoard(board);
        return "redirect:/board/list";
    }
}
