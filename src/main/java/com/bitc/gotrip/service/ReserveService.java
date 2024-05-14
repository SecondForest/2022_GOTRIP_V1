package com.bitc.gotrip.service;

import com.bitc.gotrip.dto.ReserveDto;
import com.github.pagehelper.Page;

public interface ReserveService {
    void insertReserve(ReserveDto reserve) throws Exception;

    Page<ReserveDto> selectReserveListPage(String memberId ,int pageNum) throws Exception;

    void deleteReserve(int reservePk) throws Exception;

    ReserveDto selectReserveDetail(int reservePk) throws Exception;
}
