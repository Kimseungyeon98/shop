package ksy.shop.member.service;

import ksy.shop.member.vo.MemberVO;

public interface MemberService {
    public void insertMember(MemberVO member);
    public MemberVO selectMember(Long num);
    public MemberVO selectMemberById(String id);
}
