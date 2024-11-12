package ksy.shop.board.dao;

import ksy.shop.board.domain.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public void insertBoard(BoardDTO board);
    public List<BoardDTO> selectBoardList(String keyword);
    public BoardDTO selectBoard(Long num);
}
