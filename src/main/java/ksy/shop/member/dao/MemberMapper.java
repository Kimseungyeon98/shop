package ksy.shop.member.dao;

import ksy.shop.member.vo.MemberVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    //회원가입
    public void insertMember(MemberVO member);
    //회원 찾기
    public MemberVO selectMember(Long num);
    //아이디로 회원 찾기
    public MemberVO selectMemberById(String id);

}
