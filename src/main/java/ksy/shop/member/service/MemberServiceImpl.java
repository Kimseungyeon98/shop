package ksy.shop.member.service;

import ksy.shop.member.dao.MemberMapper;
import ksy.shop.member.vo.MemberVO;
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
    public void registerMember(MemberVO member) {
        memberMapper.insertMember(member);
    }

    @Override
    public MemberVO getMemberById(String id) {
        return memberMapper.selectMemberById(id);
    }

    @Override
    public List<MemberVO> getMemberList() {
        return memberMapper.selectMemberList();
    }
}
