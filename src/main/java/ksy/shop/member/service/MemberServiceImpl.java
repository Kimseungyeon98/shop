package ksy.shop.member.service;

import ksy.shop.member.dao.MemberMapper;
import ksy.shop.member.domain.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void registerMember(MemberDTO member) {
        memberMapper.insertMember(member);
    }

    @Override
    public MemberDTO getMemberById(String id) {
        return memberMapper.selectMemberById(id);
    }

    @Override
    public MemberDTO getMember(Long num){
        return memberMapper.selectMember(num);
    }

    @Override
    public List<MemberDTO> getMemberList() {
        return memberMapper.selectMemberList();
    }
}
