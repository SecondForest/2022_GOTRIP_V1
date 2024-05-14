package com.bitc.gotrip.service;

import com.bitc.gotrip.dto.QnADto;
import com.bitc.gotrip.mapper.QnAMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnAServiceImpl implements QnAService {

    @Autowired
    private QnAMapper qnAMapper;

    @Override
    public Page<QnADto> selectBoardListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 5);
        return qnAMapper.selectBoardListPage();
    }

    @Override
    public void insertBoard(QnADto qna) throws Exception {
        qna.setReLev(0);
        qna.setReSeq(0);

        qnAMapper.insertBoard(qna);
        int qnaPk = qnAMapper.selectQnaPk();
        qnAMapper.updateReRef(qnaPk);
    }

    @Override
    public QnADto selectBoardDetail(int qnaPk) throws Exception {
        QnADto qna = qnAMapper.selectBoardDetail(qnaPk);
        return qna;
    }

    @Override
    public void insertBoardReply(QnADto qna) throws Exception {
        qna.setMemberId("admin");
        qna.setReRef(qna.getReRef());
        qna.setReLev(qna.getReLev() + 1);
        qna.setReSeq(qna.getReSeq());
        qnAMapper.insertBoard(qna);
    }

    @Override
    public void updateBoard(QnADto qna) throws Exception {
        qnAMapper.updateBoard(qna);
    }

    @Override
    public void deleteBoard(int qnaPk) throws Exception {
        qnAMapper.deleteBoard(qnaPk);
    }

    @Override
    public List<QnADto> selectBoardListByQnaPk(int qnaPk) throws Exception {
        return qnAMapper.selectBoardListByQnaPk(qnaPk);
    }

    @Override
    public Page<QnADto> selectBoardListPageById(int pageNum, String memberId) throws Exception {
        PageHelper.startPage(pageNum, 5);
        return qnAMapper.selectBoardListPageById(memberId);
    }
}
