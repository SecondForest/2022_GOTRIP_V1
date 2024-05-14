package com.bitc.gotrip.controller;

import com.bitc.gotrip.dto.TripDto;
import com.bitc.gotrip.service.TripService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TripController2 {

    @Autowired
    private TripService tripService;




    @RequestMapping("/busan2")
    public ModelAndView tripBusan2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/busan");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaBusanListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/chungbug2")
    public ModelAndView tripChungbug2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/chungbug");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaChungbugListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/chungnam2")
    public ModelAndView tripChungnam2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/chungnam");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaChungnamListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/daegu2")
    public ModelAndView tripDaegu2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/daegu");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaDaeguListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/daejeon2")
    public ModelAndView tripDaejeon2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/daejeon");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaDaejeonListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/gangwon2")
    public ModelAndView tripGangwon2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/gangwon");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaGangwonListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/gwangju2")
    public ModelAndView tripGwangju2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/gwangju");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaGwangjuListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/gyeongbug2")
    public ModelAndView tripGyeongbug2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/gyeongbug");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaGyeongbugListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/gyeonggi2")
    public ModelAndView tripGyeonggi2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/gyeonggi");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaGyeonggiListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/gyeongnam2")
    public ModelAndView tripGyeongnam2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/gyeongnam");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaGyeongnamListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/incheon2")
    public ModelAndView tripIncheon2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/incheon");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaIncheonListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/jeju2")
    public ModelAndView tripJeju2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/jeju");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaJejuListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/jeonbug2")
    public ModelAndView tripJeonbug2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/jeonbug");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaJeonbugListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/jeonnam2")
    public ModelAndView tripJeonnam2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/jeonnam");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaJeonnamListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/sejong2")
    public ModelAndView tripSejong2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/sejong");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaSejongListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/seoul2")
    public ModelAndView tripSeoul2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/seoul");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaSeoulListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/ulsan2")
    public ModelAndView tripUlsan2(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSea/ulsan");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSeaUlsanListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }

    @RequestMapping("/busan3")
    public ModelAndView tripBusan3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/busan");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyBusanListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/chungbug3")
    public ModelAndView tripChungbug3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/chungbug");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyChungbugListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/chungnam3")
    public ModelAndView tripChungnam3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/chungnam");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyChungnamListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/daegu3")
    public ModelAndView tripDaegu3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/daegu");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyDaeguListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/daejeon3")
    public ModelAndView tripDaejeon3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/daejeon");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyDaejeonListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/gangwon3")
    public ModelAndView tripGangwon3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/gangwon");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyGangwonListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/gwangju3")
    public ModelAndView tripGwangju3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/gwangju");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyGwangjuListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/gyeongbug3")
    public ModelAndView tripGyeongbug3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/gyeongbug");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyGyeongbugListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/gyeonggi3")
    public ModelAndView tripGyeonggi3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/gyeonggi");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyGyeonggiListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/gyeongnam3")
    public ModelAndView tripGyeongnam3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/gyeongnam");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyGyeongnamListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;
    }
    @RequestMapping("/incheon3")
    public ModelAndView tripIncheon3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/incheon");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyIncheonListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/jeju3")
    public ModelAndView tripJeju3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/jeju");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyJejuListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/jeonbug3")
    public ModelAndView tripJeonbug3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/jeonbug");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyJeonbugListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/jeonnam3")
    public ModelAndView tripJeonnam3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/jeonnam");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyJeonnamListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/sejong3")
    public ModelAndView tripSejong3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/sejong");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkySejongListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/seoul3")
    public ModelAndView tripSeoul3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/seoul");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkySeoulListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }
    @RequestMapping("/ulsan3")
    public ModelAndView tripUlsan3(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/trip/locationSky/ulsan");

        PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripSkyUlsanListPage(pageNum), 5);

        mv.addObject("dataList", dataList);

        return mv;

    }


}
