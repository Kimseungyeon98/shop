package ksy.shop.board.service;

import ksy.shop.board.dao.BoardMapper;
import ksy.shop.board.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public void registerBoard(BoardVO board) {
        boardMapper.insertBoard(board);
    }

    @Override
    public List<BoardVO> selectBoardList(String keyword) {
        return boardMapper.selectBoardList(keyword);
    }

    @Override
    public BoardVO getBoard(Long num) {
        return boardMapper.selectBoard(num);
    }
}
