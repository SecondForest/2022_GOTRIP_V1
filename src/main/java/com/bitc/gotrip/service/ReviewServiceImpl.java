package com.bitc.gotrip.service;

import com.bitc.gotrip.common.FileUtils;
import com.bitc.gotrip.dto.FileDto;
import com.bitc.gotrip.dto.ReviewDto;
import com.bitc.gotrip.mapper.ReviewMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    private FileUtils fileUtils;

    @Override
    public Page<ReviewDto> selectBoardListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 5);
        return reviewMapper.selectBoardListPage();
    }

    @Override
    public void insertBoard(ReviewDto review, MultipartHttpServletRequest multiUploadFiles) throws Exception {
        reviewMapper.insertBoard(review);

        List<FileDto> fileList = fileUtils.parseReviewFileInfo(1, review.getReviewPk(), multiUploadFiles);
        if(CollectionUtils.isEmpty(fileList) == false) {
            reviewMapper.insertBoardFileList(fileList);
        }
    }

    @Override
    public ReviewDto selectBoardDetail(int reviewPk) throws Exception {
        ReviewDto review = reviewMapper.selectBoardDetail(reviewPk);
        List<FileDto> fileList = reviewMapper.selectBoardFileList(reviewPk);
        review.setFileList(fileList);

        return review;
    }

    @Override
    public void updateBoard(ReviewDto review, MultipartHttpServletRequest multiUploadFiles) throws Exception {
        reviewMapper.updateBoard(review);
        List<FileDto> fileList = fileUtils.parseReviewFileInfo(1, review.getReviewPk(), multiUploadFiles);
        if(CollectionUtils.isEmpty(fileList) == false) {
            reviewMapper.insertBoardFileList(fileList);
        }
    }

    @Override
    public void deleteBoard(int reviewPk) throws Exception {
        reviewMapper.deleteBoard(reviewPk);
        reviewMapper.deleteFiles(reviewPk);
    }

    @Override
    public void updateBoardFile(int filePk) throws Exception {
        reviewMapper.deleteFileByFilePk(filePk);
    }

    @Override
    public Page<ReviewDto> selectBoardListPageById(int pageNum, String memberId) throws Exception {
        PageHelper.startPage(pageNum, 5);
        return reviewMapper.selectBoardListPageById(memberId);
    }


}
