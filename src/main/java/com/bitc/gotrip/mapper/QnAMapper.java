package com.bitc.gotrip.mapper;

import com.bitc.gotrip.dto.QnADto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnAMapper {

    Page<QnADto> selectBoardListPage() throws Exception;

    void insertBoard(QnADto qna) throws Exception;

    QnADto selectBoardDetail(int qnaPk) throws Exception;

    void updateBoard(QnADto qna) throws Exception;

    void deleteBoard(int qnaPk) throws Exception;
    
    int selectQnaPk() throws Exception;

    void updateReRef(int qnaPk) throws Exception;

    List<QnADto> selectBoardListByQnaPk(int qnaPk) throws Exception;

    Page<QnADto> selectBoardListPageById(String memberId) throws Exception;
}
