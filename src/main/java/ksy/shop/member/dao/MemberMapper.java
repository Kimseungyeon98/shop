package ksy.shop.member.dao;

import ksy.shop.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    //회원가입
    public void insertMember(MemberVO member);
    //아이디로 회원 찾기
    public MemberVO selectMemberById(String id);
    //회원 리스트
    public List<MemberVO> selectMemberList();
}
