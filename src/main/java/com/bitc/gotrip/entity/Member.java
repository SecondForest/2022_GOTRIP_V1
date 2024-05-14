package com.bitc.gotrip.entity;


import com.bitc.gotrip.dto.MemberCreateForm;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "member")
public class Member {
  @Id
  @Column(name = "member_pk")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String memberId;

  @Column(nullable = false)
  private String memberPw;

  @Column(nullable = false)
  private String memberName;

  private String memberAddr;

  private String memberPhone;

  private String memberEmail;

//  public static Member toModifyEntity(MemberCreateForm memberCreateForm) {
//    Member member = new Member();
//    member.setMemberId(memberCreateForm.getMember_id());
//    member.setMemberPw(memberCreateForm.getMember_pw1());
//    member.setMemberName(memberCreateForm.getMember_name());
//    member.setMemberAddr(memberCreateForm.getMember_addr());
//    member.setMemberPhone(memberCreateForm.getMember_phone());
//    member.setMemberEmail(memberCreateForm.getMember_email());
//    return member;
//  }
}
