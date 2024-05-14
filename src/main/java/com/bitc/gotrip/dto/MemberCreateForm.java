package com.bitc.gotrip.dto;

import com.bitc.gotrip.entity.Member;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class MemberCreateForm {

  private Long id;
  @Size(min = 3, max = 25)
  @NotEmpty(message = "사용자 ID는 필수 항목입니다.")
  private String member_id;

  @NotEmpty(message = "사용자 비밀번호는 필수 항목입니다.")
  private String member_pw1;

  @NotEmpty(message = "비밀번호 확인은 필수 항목입니다.")
  private String member_pw2;

  @NotEmpty(message = "사용자 이름은 필수 항목입니다.")
  private String member_name;

  private String member_addr;

  private String member_phone;

  @Email
  private String member_email;


//  public static MemberCreateForm toMemberCreateForm (Member member) {
//    MemberCreateForm memberCreateForm = new MemberCreateForm();
//    memberCreateForm.setMember_id(member.getMemberId());
//    memberCreateForm.setMember_pw1(member.getMemberPw());
//    memberCreateForm.setMember_name(memberCreateForm.getMember_name());
//    memberCreateForm.setMember_addr(memberCreateForm.getMember_addr());
//    memberCreateForm.setMember_phone(memberCreateForm.getMember_phone());
//    memberCreateForm.setMember_email(memberCreateForm.getMember_email());
//    return memberCreateForm;
//  }


}
