package com.bitc.gotrip.mapper;

import com.bitc.gotrip.dto.FileDto;
import com.bitc.gotrip.dto.ReviewDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    Page<ReviewDto> selectBoardListPage() throws Exception;

    void insertBoard(ReviewDto review) throws Exception;

    void insertBoardFileList(List<FileDto> fileList) throws Exception;

    ReviewDto selectBoardDetail(int reviewPk) throws Exception;

    List<FileDto> selectBoardFileList(int reviewPk) throws Exception;

    void updateBoard(ReviewDto review) throws Exception;

    void deleteBoard(int reviewPk) throws Exception;

    void deleteFiles(int reviewPk) throws Exception;

    void deleteFileByFilePk(int filePk) throws Exception;

    Page<ReviewDto> selectBoardListPageById(String memberId) throws Exception;
}
