package ksy.shop.board.controller;

import jakarta.servlet.http.HttpSession;
import ksy.shop.board.service.BoardService;
import ksy.shop.board.domain.BoardDTO;
import ksy.shop.member.domain.MemberDTO;
import ksy.shop.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/boards")
    public String board(Model model){
        List<BoardDTO> boardList = boardService.selectBoardList(null);
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }

    @GetMapping("/boards-ajax")
    @ResponseBody
    public List<BoardDTO> searchAjax(@RequestParam String keyword){
        List<BoardDTO> boardList = boardService.selectBoardList(keyword);
        System.out.println(boardList);
        return boardList;
    }

    @GetMapping("/boards/new")
    public String register(HttpSession session){
        MemberDTO user = (MemberDTO)session.getAttribute("user");
        if(user != null){
            return "/board/register";
        } else {
            return "/member/login";
        }
    }
    @PostMapping("/boards")
    public String register(BoardDTO board, HttpSession session){
        MemberDTO user = (MemberDTO)session.getAttribute("user");
        board.setMember(user);

        boardService.registerBoard(board);
        return "redirect:/boards";
    }

    @GetMapping("/boards/{num}")
    public String detail(@PathVariable("num") Long num, Model model){
        BoardDTO board = boardService.getBoard(num);

        board.setReg_date(DateUtil.formattingDate(board.getReg_date()));
        model.addAttribute("board", board);
        return "/board/detail";
    }
}
