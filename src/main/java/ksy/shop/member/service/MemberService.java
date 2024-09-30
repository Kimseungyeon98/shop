package ksy.shop.member.service;

import ksy.shop.member.vo.MemberVO;

import java.util.List;

public interface MemberService {
    public void registerMember(MemberVO member);
    public MemberVO getMemberById(String id);
    public MemberVO getMember(Long num);
    public List<MemberVO> getMemberList();
}
