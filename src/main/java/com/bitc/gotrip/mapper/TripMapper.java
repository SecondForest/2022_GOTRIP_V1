package com.bitc.gotrip.mapper;

import com.bitc.gotrip.dto.FileDto;
import com.bitc.gotrip.dto.TripDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TripMapper {

    List<TripDto> selectTripList() throws Exception;

    void insertTrip(TripDto trip) throws Exception;

    void insertFileList(List<FileDto> fileList) throws Exception;

    List<FileDto> selectFileList() throws Exception;

    TripDto selectTripDetail(int pkNum) throws Exception;

    List<FileDto> selectTripFileList(int pkNum) throws Exception;

    List<FileDto> selectFileDetail(int pkNum) throws Exception;

    List<TripDto> selectTripDetailList(int pkNum) throws Exception;

    void deleteTrip(int pkNum) throws Exception;

    void tripUpdate(TripDto trip) throws Exception;

    Page<TripDto> selectTripListPage() throws Exception;

//    List<FileDto> selectThumFileList()throws Exception;

    List<FileDto> selectThumFileList(int pkNum) throws Exception;

    void deleteFileByFilePk(int filePk) throws Exception;

    void updateHitCnt(int pkNum) throws Exception;

    Page<TripDto> selectTripSeaListPage()throws Exception;

    Page<TripDto> selectTripMouListPage() throws Exception;

    Page<TripDto> selectTripSkyListPage()throws Exception;

    Page<TripDto> selectTripMouBusanListPage() throws Exception;

    Page<TripDto> selectTripMouChungbugListPage() throws Exception;

    Page<TripDto> selectTripMouChungnamListPage() throws Exception;

    Page<TripDto> selectTripMouDaeguListPage() throws Exception;

    Page<TripDto> selectTripMouDaejeonListPage() throws Exception;

    Page<TripDto> selectTripMouGangwonListPage() throws Exception;

    Page<TripDto> selectTripMouGwangjuListPage() throws Exception;

    Page<TripDto> selectTripMouGyeongbugListPage() throws Exception;

    Page<TripDto> selectTripMouGyeonggiListPage() throws Exception;

    Page<TripDto> selectTripMouGyeongnamListPage() throws Exception;

    Page<TripDto> selectTripMouIncheonListPage() throws Exception;

    Page<TripDto> selectTripMouJejuListPage() throws Exception;

    Page<TripDto> selectTripMouJeonbugListPage() throws Exception;

    Page<TripDto> selectTripMouJeonnamListPage() throws Exception;

    Page<TripDto> selectTripMouSejongListPage() throws Exception;

    Page<TripDto> selectTripMouSeoulListPage() throws Exception;

    Page<TripDto> selectTripMouUlsanListPage() throws Exception;

    Page<TripDto> selectTripSkyBusanListPage() throws Exception;

    Page<TripDto> selectTripSkyChungbugListPage() throws Exception;

    Page<TripDto> selectTripSkyChungnamListPage() throws Exception;

    Page<TripDto> selectTripSkyDaeguListPage() throws Exception;

    Page<TripDto> selectTripSkyDaejeonListPage() throws Exception;

    Page<TripDto> selectTripSkyGangwonListPage() throws Exception;

    Page<TripDto> selectTripSkyGwangjuListPage() throws Exception;

    Page<TripDto> selectTripSkyGyeongbugListPage() throws Exception;

    Page<TripDto> selectTripSkyGyeonggiListPage() throws Exception;

    Page<TripDto> selectTripSkyGyeongnamListPage() throws Exception;

    Page<TripDto> selectTripSkyIncheonListPage() throws Exception;

    Page<TripDto> selectTripSkyJejuListPage() throws Exception;

    Page<TripDto> selectTripSkyJeonbugListPage() throws Exception;

    Page<TripDto> selectTripSkyJeonnamListPage() throws Exception;

    Page<TripDto> selectTripSkySejongListPage() throws Exception;

    Page<TripDto> selectTripSkySeoulListPage() throws Exception;

    Page<TripDto> selectTripSkyUlsanListPage() throws Exception;

    Page<TripDto> selectTripSeaBusanListPage() throws Exception;

    Page<TripDto> selectTripSeaChungbugListPage() throws Exception;

    Page<TripDto> selectTripSeaChungnamListPage() throws Exception;

    Page<TripDto> selectTripSeaDaeguListPage() throws Exception;

    Page<TripDto> selectTripSeaDaejeonListPage() throws Exception;

    Page<TripDto> selectTripSeaGangwonListPage() throws Exception;

    Page<TripDto> selectTripSeaGwangjuListPage() throws Exception;

    Page<TripDto> selectTripSeaGyeongbugListPage() throws Exception;

    Page<TripDto> selectTripSeaGyeonggiListPage() throws Exception;

    Page<TripDto> selectTripSeaGyeongnamListPage() throws Exception;

    Page<TripDto> selectTripSeaIncheonListPage() throws Exception;

    Page<TripDto> selectTripSeaJejuListPage() throws Exception;

    Page<TripDto> selectTripSeaJeonbugListPage() throws Exception;

    Page<TripDto> selectTripSeaJeonnamListPage() throws Exception;

    Page<TripDto> selectTripSeaSejongListPage() throws Exception;

    Page<TripDto> selectTripSeaSeoulListPage() throws Exception;

    Page<TripDto> selectTripSeaUlsanListPage() throws Exception;

    void insertMyLike(HashMap<String, Object> map) throws Exception;

    void deleteMyLike(HashMap<String, Object> map) throws Exception;
}
