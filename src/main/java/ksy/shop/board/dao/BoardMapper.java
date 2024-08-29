package ksy.shop.board.dao;

import ksy.shop.board.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public void insertBoard(BoardVO board);
    public List<BoardVO> selectBoardList();
}
