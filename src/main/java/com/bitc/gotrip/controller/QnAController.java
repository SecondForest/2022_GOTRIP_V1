package com.bitc.gotrip.controller;

import com.bitc.gotrip.dto.QnADto;
import com.bitc.gotrip.service.QnAService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QnAController {

    @Autowired
    private QnAService qnAService;

    @RequestMapping("/qna/boardList")
    public ModelAndView qnaOpenBoardList(@RequestParam(required = false, defaultValue = "1") int pageNum, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("/qna/boardList");
        PageInfo<QnADto> dataList = new PageInfo<>(qnAService.selectBoardListPage(pageNum), 5);
        mv.addObject("dataList", dataList);

        return mv;
    }

    @RequestMapping("/qna/writeBoard")
    public String qnaWriteBoard() throws Exception {
        return "/qna/boardWrite";
    }

    @RequestMapping("/qna/insertBoard")
    public String qnaInsertBoard(QnADto qna) throws Exception {
        qnAService.insertBoard(qna);
        return "redirect:/qna/boardList";
    }

    @RequestMapping("/qna/boardDetail")
    public ModelAndView qnaBoardDetail(@RequestParam("qnaPk") int qnaPk, Principal principal) throws Exception {
        ModelAndView mv = new ModelAndView("/qna/boardDetail");
        // 현재 로그인된 아이디값 가져오기
        String memberId = null;
        if(principal == null) {
            memberId = " ";
        }else {
            memberId = principal.getName();
        }
        mv.addObject("memberId", memberId);
        // re_ref = 'qnaPk'로 select 하여 나온 글 목록 가져오기
        List<QnADto> dataList = new ArrayList<>(qnAService.selectBoardListByQnaPk(qnaPk));
        mv.addObject("dataList", dataList);

        QnADto qna = qnAService.selectBoardDetail(qnaPk);
        mv.addObject("qna", qna);

        return mv;
    }

    @RequestMapping("/qna/replyBoard")
    public ModelAndView qnaReplyBoard(@RequestParam("reRef") int reRef, @RequestParam("reLev") int reLev,
                                @RequestParam("reSeq") int reSeq, @RequestParam("qnaPk") int qnaPk) throws Exception{
        ModelAndView mv = new ModelAndView("/qna/boardReplyWrite");
        mv.addObject("reRef", reRef);
        mv.addObject("reLev", reLev);
        mv.addObject("reSeq", reSeq);
        QnADto qna = qnAService.selectBoardDetail(qnaPk);
        mv.addObject("qna", qna);
        return mv;
    }

    @RequestMapping("/qna/insertBoardReply")
    public String qnaInsertBoardReply(QnADto qna, @RequestParam("targetReRef") int reRef, @RequestParam("targetReLev") int reLev,
                                      @RequestParam("targetReSeq") int reSeq) throws Exception {
        qna.setReRef(reRef);
        qna.setReLev(reLev);
        qna.setReSeq(0);
        qnAService.insertBoardReply(qna);
        return "redirect:/qna/boardList";
    }

    @RequestMapping("/qna/updateBoard")
    public String reviewUpdateBoard(QnADto qna) throws Exception {
        qnAService.updateBoard(qna);
        return "redirect:/qna/boardList";
    }

    @RequestMapping("/qna/deleteBoard")
    public String reviewDeleteBoard(@RequestParam int qnaPk) throws Exception {
        qnAService.deleteBoard(qnaPk);
        return "redirect:/qna/boardList";
    }

}
