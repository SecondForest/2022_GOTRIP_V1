package com.bitc.gotrip.controller;

import com.bitc.gotrip.dto.ReserveDto;
import com.bitc.gotrip.dto.ReviewDto;
import com.bitc.gotrip.service.ReviewService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    // 게시판 전체 목록 출력
    @RequestMapping("/review/boardList")
    public ModelAndView reviewOpenBoardList(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("/review/boardList");
        PageInfo<ReviewDto> dataList = new PageInfo<>(reviewService.selectBoardListPage(pageNum), 5);
        mv.addObject("dataList", dataList);

        return mv;
    }

    @RequestMapping("/review/writeBoard")
    public ModelAndView reviewWriteBoard(ReserveDto reserve, Principal principal) throws Exception {
        ModelAndView mv = new ModelAndView("/review/boardWrite");
        // 세션에서 아이디값 가져와서 예약자 정보 가져오기
        String memberId = principal.getName();

        mv.addObject("memberId", memberId);
        mv.addObject("reserve", reserve);
        return mv;
    }

    @RequestMapping("/review/insertBoard")
    public String reviewInsertBoard(ReviewDto review, MultipartHttpServletRequest multiUploadFiles) throws Exception {
        reviewService.insertBoard(review, multiUploadFiles);
        return "redirect:/review/boardList";
    }

    @RequestMapping("/review/boardDetail")
    public ModelAndView reviewBoardDetail(@RequestParam("reviewPk") int reviewPk, Principal principal) throws Exception {
        ModelAndView mv = new ModelAndView("/review/boardDetail");
        // 현재 로그인된 아이디값 가져오기
        String memberId = null;
        if(principal == null) {
            memberId = " ";
        }else {
            memberId = principal.getName();
        }
        mv.addObject("memberId", memberId);

        ReviewDto review = reviewService.selectBoardDetail(reviewPk);
        mv.addObject("review", review);

        return mv;
    }

    @RequestMapping("/review/updateBoard")
    public String reviewUpdateBoard(ReviewDto review, MultipartHttpServletRequest multiUploadFiles,
                                    @RequestParam(value = "deleteFileList") List<Integer> fileList) throws Exception {
        reviewService.updateBoard(review, multiUploadFiles);
        if(fileList.size() > 0) {
            for (Integer filePk : fileList) {
                reviewService.updateBoardFile(filePk);
            }
        }

        return "redirect:/review/boardList";
    }

    @ResponseBody
    @RequestMapping(value = "/review/boardFileDelete", method = RequestMethod.POST)
    public Object boardFileDelete(@RequestParam(value = "fileList[]") String fileList) throws Exception {

        if(fileList.length() > 0) {
            String[] tmp = fileList.split(",");
            for(String tmpNum : tmp) {
                int filePk = parseInt(tmpNum);
                reviewService.updateBoardFile(filePk);
            }
        }


        return "redirect:/review/boardList";
    }

    @RequestMapping("/review/deleteBoard")
    public String reviewDeleteBoard(@RequestParam int reviewPk) throws Exception {
        reviewService.deleteBoard(reviewPk);
        return "redirect:/review/boardList";
    }

}
