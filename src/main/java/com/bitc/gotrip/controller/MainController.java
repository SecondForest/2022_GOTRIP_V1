package com.bitc.gotrip.controller;

import com.bitc.gotrip.dto.QnADto;
import com.bitc.gotrip.dto.ReviewDto;
import com.bitc.gotrip.dto.TripDto;
import com.bitc.gotrip.service.QnAService;
import com.bitc.gotrip.service.ReviewService;
import com.bitc.gotrip.service.TripService;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class MainController {

  @Autowired
  private TripService tripService;

  @Autowired
  private ReviewService reviewService;

  @Autowired
  private QnAService qnAService;

  @RequestMapping(value = "/")
  public ModelAndView main(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception{
    ModelAndView mv = new ModelAndView("/main");
    PageInfo<TripDto> dataList = new PageInfo<>(tripService.selectTripListPage(pageNum), 5);
    mv.addObject("dataList", dataList);

    PageInfo<ReviewDto> reviewList = new PageInfo<>(reviewService.selectBoardListPage(pageNum), 5);
    mv.addObject("reviewList", reviewList);

    PageInfo<QnADto> qnaList = new PageInfo<>(qnAService.selectBoardListPage(pageNum), 5);
    mv.addObject("qnaList", qnaList);

    return mv;
  }
}
