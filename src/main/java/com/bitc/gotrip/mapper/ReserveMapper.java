package com.bitc.gotrip.mapper;

import com.bitc.gotrip.dto.FileDto;
import com.bitc.gotrip.dto.ReserveDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReserveMapper {
    void insertReserve(ReserveDto reserve) throws Exception;

    Page<ReserveDto> selectReserveListPage(String memberId) throws Exception;

    List<FileDto> selectThumFileList(int tripPk) throws Exception;

    void deleteReserve(int reservePk) throws Exception;

    ReserveDto selectReserveDetail(int reservePk) throws Exception;
}
