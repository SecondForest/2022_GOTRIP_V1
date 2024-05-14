package com.bitc.gotrip.controller;

import com.bitc.gotrip.dto.ReserveDto;
import com.bitc.gotrip.dto.TripDto;
import com.bitc.gotrip.entity.Member;
import com.bitc.gotrip.service.MemberService;
import com.bitc.gotrip.service.ReserveService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Executable;
import java.security.Principal;

@Controller
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @Autowired
    private MemberService memberService;

    @RequestMapping("/reserveView")
    public ModelAndView reserveOpenView(TripDto trip, @RequestParam("reserveStart") String reserveStart,
                                        @RequestParam("reserveEnd") String reserveEnd, @RequestParam("reserveCount") int reserveCount,
                                        Principal principal) throws Exception {
        ModelAndView mv = new ModelAndView("/reserve/reserve");
        // 여행번호, 위치(지역), 테마 가져오기
        int tripPk = trip.getPkNum();
        String tripRegion = null;
        String tripCategory = null;
        switch (trip.getTripRegionPk()) {
            case 1 :
                tripRegion = "서울";
                break;
            case 2 :
                tripRegion = "인천";
                break;
            case 3 :
                tripRegion = "대전";
                break;
            case 4 :
                tripRegion = "대구";
                break;
            case 5 :
                tripRegion = "광주";
                break;
            case 6 :
                tripRegion = "부산";
                break;
            case 7 :
                tripRegion = "울산";
                break;
            case 8 :
                tripRegion = "세종";
                break;
            case 9 :
                tripRegion = "경기";
                break;
            case 10 :
                tripRegion = "강원";
                break;
            case 11 :
                tripRegion = "충북";
                break;
            case 12 :
                tripRegion = "충남";
                break;
            case 13 :
                tripRegion = "경북";
                break;
            case 14 :
                tripRegion = "경남";
                break;
            case 15 :
                tripRegion = "전북";
                break;
            case 16 :
                tripRegion = "전남";
                break;
            case 17 :
                tripRegion = "제주";
                break;
            default:
                break;
        }
        switch (trip.getTripCategoryPk()) {
            case 1:
                tripCategory = "산";
                break;
            case 2:
                tripCategory = "바다";
                break;
            case 3:
                tripCategory = "하늘";
                break;
            default:
                break;
        }
        // 세션에서 아이디값 가져와서 예약자 정보 가져오기
        Member user = new Member();
        if(principal == null) {
            user.setMemberId(" ");
        }else {
            user.setMemberId(principal.getName());
        }

        user = memberService.getMemberInfo(user.getMemberId());
        mv.addObject("member", user);

        // 예약페이지에 넘겨줄 값 저장
        mv.addObject("trip", trip);
        mv.addObject("tripPk", tripPk);
        mv.addObject("tripRegion", tripRegion);
        mv.addObject("tripCategory", tripCategory);
        mv.addObject("reserveStart", reserveStart);
        mv.addObject("reserveEnd", reserveEnd);
        mv.addObject("reserveCount", reserveCount);

        return mv;
    }

    @RequestMapping("/insertReserve")
    public String reserveInsertInfo(ReserveDto reserve, Principal principal) throws Exception {
        // 세션에서 아이디값 가져와서 예약자 정보 가져오기
        reserve.setMemberId(principal.getName());

        reserveService.insertReserve(reserve);
        return "redirect:/reserve/reserveList";
    }

    @RequestMapping("/reserveList")
    public ModelAndView reserveMyReserveList(@RequestParam(required = false, defaultValue = "1") int pageNum,
                                             Principal principal) throws Exception{
        ModelAndView mv = new ModelAndView("/reserve/reserveList");

        // 세션에서 아이디값 가져와서 예약자 정보 가져오기
        Member user = new Member();
        user.setMemberId(principal.getName());

        mv.addObject("user", user);

//        String memberId = "roadofruin";
        PageInfo<ReserveDto> dataList = new PageInfo<>(reserveService.selectReserveListPage(user.getMemberId(), pageNum), 5);
        mv.addObject("dataList", dataList);

        return mv;
    }

    @RequestMapping("/reserveDetail")
    public ModelAndView reserveDetail(@RequestParam("reservePk") int reservePk) throws Exception {
        ModelAndView mv = new ModelAndView();
        ReserveDto reserve = reserveService.selectReserveDetail(reservePk);
        // 위치(지역), 테마 가져오기
        String tripRegion = null;
        String tripCategory = null;
        switch (reserve.getTripRegionPk()) {
            case 1 :
                tripRegion = "서울";
                break;
            case 2 :
                tripRegion = "인천";
                break;
            case 3 :
                tripRegion = "대전";
                break;
            case 4 :
                tripRegion = "대구";
                break;
            case 5 :
                tripRegion = "광주";
                break;
            case 6 :
                tripRegion = "부산";
                break;
            case 7 :
                tripRegion = "울산";
                break;
            case 8 :
                tripRegion = "세종";
                break;
            case 9 :
                tripRegion = "경기";
                break;
            case 10 :
                tripRegion = "강원";
                break;
            case 11 :
                tripRegion = "충북";
                break;
            case 12 :
                tripRegion = "충남";
                break;
            case 13 :
                tripRegion = "경북";
                break;
            case 14 :
                tripRegion = "경남";
                break;
            case 15 :
                tripRegion = "전북";
                break;
            case 16 :
                tripRegion = "전남";
                break;
            case 17 :
                tripRegion = "제주";
                break;
            default:
                break;
        }
        switch (reserve.getTripCategoryPk()) {
            case 1:
                tripCategory = "산";
                break;
            case 2:
                tripCategory = "바다";
                break;
            case 3:
                tripCategory = "하늘";
                break;
            default:
                break;
        }

        mv.addObject("reserve", reserve);
        mv.addObject("tripRegion", tripRegion);
        mv.addObject("tripCategory", tripCategory);
        return mv;
    }

    @RequestMapping("/deleteReserve")
    public String reserveDelete(@RequestParam("reservePk") int reservePk) throws Exception {
        reserveService.deleteReserve(reservePk);
        return "redirect:/reserve/reserveList";
    }
}
