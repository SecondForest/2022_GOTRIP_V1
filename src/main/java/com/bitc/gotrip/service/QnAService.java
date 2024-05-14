package com.bitc.gotrip.service;

import com.bitc.gotrip.dto.QnADto;
import com.github.pagehelper.Page;

import java.util.List;

public interface QnAService {

    Page<QnADto> selectBoardListPage(int pageNum) throws Exception;

    void insertBoard(QnADto qna) throws Exception;

    QnADto selectBoardDetail(int qnaPk) throws Exception;

    void insertBoardReply(QnADto qna) throws Exception;

    void updateBoard(QnADto qna) throws Exception;

    void deleteBoard(int qnaPk) throws Exception;

    List<QnADto> selectBoardListByQnaPk(int qnaPk) throws Exception;

    Page<QnADto> selectBoardListPageById(int pageNum, String memberId) throws Exception;
}
