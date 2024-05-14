package com.bitc.gotrip.service;

import com.bitc.gotrip.dto.FileDto;
import com.bitc.gotrip.dto.ReserveDto;
import com.bitc.gotrip.mapper.ReserveMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private ReserveMapper reserveMapper;

    @Override
    public void insertReserve(ReserveDto reserve) throws Exception {
        reserveMapper.insertReserve(reserve);
    }

    @Override
    public Page<ReserveDto> selectReserveListPage(String memberId, int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 5);

        Page<ReserveDto> dataList = reserveMapper.selectReserveListPage(memberId);

        for(ReserveDto reserve : dataList) {
            // 예약 한 개당 여행지 사진 하나씩 넣기
            List<FileDto> fileList = reserveMapper.selectThumFileList(reserve.getTripPk());
            reserve.setFileList(fileList);
//            // 예약별로 여행지위치 한글로 넣어두기
//            String reserveRegionPk = null;
//            reserve.getTripRegionPk()
        }
        return dataList;
    }

    @Override
    public void deleteReserve(int reservePk) throws Exception {
        reserveMapper.deleteReserve(reservePk);
    }

    @Override
    public ReserveDto selectReserveDetail(int reservePk) throws Exception {
        ReserveDto reserve = reserveMapper.selectReserveDetail(reservePk);
        return reserve;
    }
}
