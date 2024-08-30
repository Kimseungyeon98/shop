package ksy.shop.board.service;

import ksy.shop.board.vo.BoardVO;

import java.util.List;

public interface BoardService {
    public void registerBoard(BoardVO board);
    public List<BoardVO> selectBoardList();
    public BoardVO getBoard(Long num);
}
