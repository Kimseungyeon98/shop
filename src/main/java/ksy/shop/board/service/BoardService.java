package ksy.shop.board.service;

import ksy.shop.board.domain.BoardDTO;

import java.util.List;

public interface BoardService {
    public void registerBoard(BoardDTO board);
    public List<BoardDTO> selectBoardList(String keyword);
    public BoardDTO getBoard(Long num);
}
