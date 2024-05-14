package com.bitc.gotrip.controller;

import com.bitc.gotrip.dto.FileDto;
import com.bitc.gotrip.dto.TripDto;
import com.bitc.gotrip.service.TripService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@Controller
public class TripController {

    @Autowired
    private TripService tripService;


    @ResponseBody
    @RequestMapping("/trip/insertMyLike")
    public Object tripInsertMyLike(@RequestParam("tripPk") int tripPk, Principal principal) throws Exception {
        // 아이디 값 가져오기
        String memberId = principal.getName();
        // HashMap으로 두 가지 타입의 값 담기
        HashMap<String, Object > map = new HashMap<String, Object>();
        map.put("memberId", memberId);
        map.put("tripPk", tripPk);
        tripService.insertMyLike(map);
        return "여행지가 찜되었습니다.";
    }

    @ResponseBody
    @RequestMapping("/trip/deleteMyLike")
    public Object tripDeleteMyLike(@RequestParam("tripPk") int tripPk, Principal principal) throws Exception {
        // 아이디 값 가져오기
        String memberId = principal.getName();
        // HashMap으로 두 가지 타입의 값 담기
        HashMap<String, Object > map = new HashMap<String, Object>();
        map.put("memberId", memberId);
        map.put("tripPk", tripPk);
        tripService.deleteMyLike(map);
        return "여행지가 찜해제되었습니다.";
    }

    @RequestMapping("/tripDetail")
    public ModelAndView tripDetail(@RequestParam("pkNum") int pkNum, Principal principal) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/tripDetail");

        TripDto trip = tripService.selectTripDetail(pkNum);
        mv.addObject("trip", trip);

        List<FileDto> files = tripService.selectFileDetail(pkNum);
        mv.addObject("files", files);

        // 현재 로그인된 아이디값 가져오기
        String memberId = null;
        if(principal == null) {
            memberId = " ";
        }else {
            memberId = principal.getName();
        }
        mv.addObject("memberId", memberId);

        return mv;
    }

    @RequestMapping("/sea")
    public ModelAndView tripSeaList(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/tripSea");
        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }

    @RequestMapping("/sky")
    public ModelAndView tripSkyList(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/tripSky");
        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }

    @RequestMapping("/mou")
    public ModelAndView tripMouList(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/tripMou");
        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }

    @RequestMapping("/busan")
    public ModelAndView tripBusan(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/busan");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouBusanListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/chungbug")
    public ModelAndView tripChungbug(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/chungbug");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouChungbugListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/chungnam")
    public ModelAndView tripChungnam(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/chungnam");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouChungnamListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/daegu")
    public ModelAndView tripDaegu(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/daegu");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouDaeguListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/daejeon")
    public ModelAndView tripDaejeon(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/daejeon");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouDaejeonListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/gangwon")
    public ModelAndView tripGangwon(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/gangwon");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouGangwonListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/gwangju")
    public ModelAndView tripGwangju(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/gwangju");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouGwangjuListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/gyeongbug")
    public ModelAndView tripGyeongbug(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/gyeongbug");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouGyeongbugListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/gyeonggi")
    public ModelAndView tripGyeonggi(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/gyeonggi");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouGyeonggiListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/gyeongnam")
    public ModelAndView tripGyeongnam(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/gyeongnam");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouGyeongnamListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/incheon")
    public ModelAndView tripIncheon(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/incheon");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouIncheonListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/jeju")
    public ModelAndView tripJeju(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/jeju");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouJejuListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/jeonbug")
    public ModelAndView tripJeonbug(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/jeonbug");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouJeonbugListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/jeonnam")
    public ModelAndView tripJeonnam(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/jeonnam");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouJeonnamListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/sejong")
    public ModelAndView tripSejong(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/sejong");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouSejongListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/seoul")
    public ModelAndView tripSeoul(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/seoul");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouSeoulListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/ulsan")
    public ModelAndView tripUlsan(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationMou/ulsan");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripMouUlsanListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }

}
