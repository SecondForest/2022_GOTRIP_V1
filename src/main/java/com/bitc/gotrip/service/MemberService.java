package com.bitc.gotrip.service;

import com.bitc.gotrip.dto.MemberCreateForm;
import com.bitc.gotrip.entity.Member;
import com.bitc.gotrip.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  public Member create(String memberId, String memberPw, String memberName, String memberAddr, String memberPhone, String memberEmail) {
    Member member = new Member();
    member.setMemberId(memberId);
    member.setMemberPw(passwordEncoder.encode(memberPw));
    member.setMemberName(memberName);
    member.setMemberAddr(memberAddr);
    member.setMemberPhone(memberPhone);
    member.setMemberEmail(memberEmail);
    this.memberRepository.save(member);
    return member;
  }

  public Member getMemberInfo(String memberId) {

    Optional<Member> _member = this.memberRepository.findByMemberId(memberId);
    Member member = _member.get();
    return member;
  }
  public void update(Long id, String memberId, String memberPw, String memberName, String memberAddr, String memberPhone, String memberEmail) {
    Member member = new Member();
    member.setId(id);
    member.setMemberId(memberId);
    member.setMemberPw(passwordEncoder.encode(memberPw));
    member.setMemberName(memberName);
    member.setMemberAddr(memberAddr);
    member.setMemberPhone(memberPhone);
    member.setMemberEmail(memberEmail);
    this.memberRepository.save(member);
  }
  

//  public MemberCreateForm findByMemberId(String memberId) {
//    Optional<Member> optionalUserEntity = (memberRepository.findByMemberId(memberId));
//    if (optionalUserEntity.isPresent()) {
//      Member member = optionalUserEntity.get();
//      MemberCreateForm memberCreateForm = MemberCreateForm.toMemberCreateForm(member);
//      return memberCreateForm;
//    } else {
//      return null;
//    }
//  }
//
//  public void modify(MemberCreateForm memberCreateForm) {memberRepository.save(Member.toModifyEntity(memberCreateForm));}
}
