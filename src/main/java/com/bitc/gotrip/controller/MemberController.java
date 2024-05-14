package com.bitc.gotrip.controller;

import com.bitc.gotrip.dto.MemberCreateForm;
import com.bitc.gotrip.dto.QnADto;
import com.bitc.gotrip.dto.ReviewDto;
import com.bitc.gotrip.entity.Member;
import com.bitc.gotrip.repository.MemberRepository;
import com.bitc.gotrip.service.MemberService;
import com.bitc.gotrip.service.QnAService;
import com.bitc.gotrip.service.ReviewService;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {
  private final MemberService memberService;
  @Autowired
  public ReviewService reviewService;

  @Autowired
  private QnAService qnAService;

  @GetMapping("/signup")
  public String signup(MemberCreateForm memberCreateForm) {
    return "member/member_form";
  }

  @PostMapping("/signup")
  public String signup(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "/member/member_form";
    }
    if (!memberCreateForm.getMember_pw1().equals(memberCreateForm.getMember_pw2())) {
      bindingResult.rejectValue("memberPw2", "memberPwInCorrect", "2개의 패스워드가 일치하지 않습니다.");
      return "/member/member_form";
    }
    try {
      memberService.create(memberCreateForm.getMember_id(), memberCreateForm.getMember_pw1(), memberCreateForm.getMember_name(), memberCreateForm.getMember_addr(), memberCreateForm.getMember_phone(), memberCreateForm.getMember_email());
    } catch (DataIntegrityViolationException e) {
      e.printStackTrace();
      bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
      return "/member/member_form";
    } catch (Exception e) {
      e.printStackTrace();
      bindingResult.reject("signupFailed", e.getMessage());
      return "/member/member_form";
    }
    return "redirect:/";
  }

  @GetMapping("/login")
  public String login() {
    return "/member/login_form";
  }

  @RequestMapping(value = "/myPage", method = RequestMethod.GET)
  public ModelAndView memberOpenMyPage(Principal principal) {
    ModelAndView mv = new ModelAndView("/mypage/my_me");
    // 세션에서 아이디값 가져오기
    Member user = new Member();
    user = memberService.getMemberInfo(principal.getName());

    mv.addObject("user", user);

    return mv;
  }


  @RequestMapping(value = "/myEdit", method = RequestMethod.GET)
  public ModelAndView memberEditPage(Principal principal) {
    ModelAndView mv = new ModelAndView("/mypage/my_edit");
    // 세션에서 아이디값 가져오기
    Member user = new Member();
    user = memberService.getMemberInfo(principal.getName());

    mv.addObject("member", user);

    return mv;
  }

  @RequestMapping("/myReview")
  public ModelAndView myReview(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request, Principal principal) throws Exception {
    ModelAndView mv = new ModelAndView("/mypage/my_review_qna");

    Member user = new Member();
    user = memberService.getMemberInfo(principal.getName());

    mv.addObject("user", user);

//    PageInfo<ReviewDto> reviewList = new PageInfo<>(reviewService.selectBoardListPage(pageNum), 5);
    PageInfo<ReviewDto> reviewList = new PageInfo<>(reviewService.selectBoardListPageById(pageNum, user.getMemberId()), 5);
    mv.addObject("reviewList", reviewList);

//    PageInfo<QnADto> qnaList = new PageInfo<>(qnAService.selectBoardListPage(pageNum), 5);
    PageInfo<QnADto> qnaList = new PageInfo<>(qnAService.selectBoardListPageById(pageNum, user.getMemberId()), 5);
    mv.addObject("qnaList", qnaList);


    return mv;
  }
  @RequestMapping(value = "/updateEdit", method = RequestMethod.POST)
  public String myEdit(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult){
    if (bindingResult.hasErrors()){
      return "/mypage/my_edit";
    }
    if (!memberCreateForm.getMember_pw1().equals(memberCreateForm.getMember_pw2())) {
      bindingResult.rejectValue("memberPw2", "memberPwInCorrect", "2개의 패스워드가 일치하지 않습니다.");
      return "/mypage/my_edit";
    }
    try {
      memberService.update(memberCreateForm.getId(), memberCreateForm.getMember_id(), memberCreateForm.getMember_pw1(), memberCreateForm.getMember_name(), memberCreateForm.getMember_addr(), memberCreateForm.getMember_phone(), memberCreateForm.getMember_email());
    } catch (Exception e) {
      e.printStackTrace();
      bindingResult.reject("editFailed",e.getMessage());
      return "redirect:/mypage/my_edit";
    }
    return "redirect:/";
  }


//  @GetMapping("/edit")
//  public String edit(HttpSession session, Model model) {
//    String memberId = (String) session.getAttribute("memberId");
//    MemberCreateForm memberCreateForm = memberService.findByMemberId(memberId);
//    model.addAttribute("modifyMember", memberCreateForm);
//    return "mypage/my_edit";
//  }
//
//  @PostMapping("/edit")
//  public String modify(@ModelAttribute MemberCreateForm memberCreateForm) {
//    memberService.modify(memberCreateForm);
//    return "redirect:/";
//  }
//  @{/member/updateEdit}

}
