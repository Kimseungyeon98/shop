package ksy.shop.member.dao;

import ksy.shop.member.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    //회원가입
    public void insertMember(MemberDTO member);
    //아이디로 회원 찾기
    public MemberDTO selectMemberById(String id);
    //회원번호로 회원 찾기
    public MemberDTO selectMember(Long num);
    //회원 리스트
    public List<MemberDTO> selectMemberList();
}
