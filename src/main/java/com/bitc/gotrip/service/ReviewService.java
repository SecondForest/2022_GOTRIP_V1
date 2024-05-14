package com.bitc.gotrip.service;

import com.bitc.gotrip.dto.ReviewDto;
import com.github.pagehelper.Page;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ReviewService {
    Page<ReviewDto> selectBoardListPage(int pageNum) throws Exception;

    void insertBoard(ReviewDto review, MultipartHttpServletRequest multiUploadFiles) throws Exception;

    ReviewDto selectBoardDetail(int reviewPk) throws Exception;

    void updateBoard(ReviewDto review, MultipartHttpServletRequest multiUploadFiles) throws Exception;

    void deleteBoard(int reviewPk) throws Exception;

    void updateBoardFile(int filePk) throws Exception;

    Page<ReviewDto> selectBoardListPageById(int pageNum, String memberId) throws Exception;

//    List<FileDto> selectBoardFileList(int reviewPk) throws Exception;
}
