package ksy.shop.member.service;

import ksy.shop.member.domain.MemberDTO;

import java.util.List;

public interface MemberService {
    public void registerMember(MemberDTO member);
    public MemberDTO getMemberById(String id);
    public MemberDTO getMember(Long num);
    public List<MemberDTO> getMemberList();
}
