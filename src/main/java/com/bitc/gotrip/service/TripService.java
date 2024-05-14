package com.bitc.gotrip.service;

import com.bitc.gotrip.dto.FileDto;
import com.bitc.gotrip.dto.TripDto;
import com.github.pagehelper.Page;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.HashMap;
import java.util.List;

public interface TripService {

    List<TripDto> selectTripList() throws Exception;

    void insertTrip(int tripCategoryPk, int tripRegionPk, String tripName, int tripPrice, String tripContents, Double tripLatitude, Double tripHardness) throws Exception;

    void insertTrip(TripDto trip, MultipartHttpServletRequest multiUploadFiles) throws Exception;


    List<FileDto> selectFileList() throws Exception;

    TripDto selectTripDetail(int pkNum) throws Exception;

    List<FileDto> selectFileDetail(int pkNum) throws Exception;

    void deleteTrip(int pkNum) throws Exception;

    void tripUpdate(TripDto trip, MultipartHttpServletRequest multiUploadFiles) throws Exception;

    Page<TripDto> selectTripListPage(int pageNum) throws Exception;

//    List<FileDto> selectThumFileList()throws Exception;

    List<FileDto> selectThumFileList(int pkNum) throws Exception;

    void updateTripFile(int filePk) throws Exception;

    Page<TripDto> selectTripSeaListPage(int pageNum) throws Exception;
    Page<TripDto> selectTripMouListPage(int pageNum) throws Exception;
    Page<TripDto> selectTripSkyListPage(int pageNum) throws Exception;

    /* ------------------------------------------------------*/
    Page<TripDto> selectTripMouBusanListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripMouChungbugListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripMouChungnamListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripMouDaeguListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripMouDaejeonListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripMouGangwonListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripMouGwangjuListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripMouGyeongbugListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripMouGyeonggiListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripMouGyeongnamListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripMouIncheonListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripMouJejuListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripMouJeonbugListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripMouJeonnamListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripMouSejongListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripMouSeoulListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripMouUlsanListPage(int pageNum)throws Exception;

    /* ------------------------------------------------------*/
    Page<TripDto> selectTripSkyBusanListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripSkyChungbugListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripSkyChungnamListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripSkyDaeguListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripSkyDaejeonListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripSkyGangwonListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSkyGwangjuListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSkyGyeongbugListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSkyGyeonggiListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSkyGyeongnamListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSkyIncheonListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSkyJejuListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSkyJeonbugListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSkyJeonnamListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSkySejongListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSkySeoulListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSkyUlsanListPage(int pageNum)throws Exception;

    /* ------------------------------------------------------*/

    Page<TripDto> selectTripSeaBusanListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripSeaChungbugListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripSeaChungnamListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripSeaDaeguListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripSeaDaejeonListPage(int pageNum) throws Exception;

    Page<TripDto> selectTripSeaGangwonListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSeaGwangjuListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSeaGyeongbugListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSeaGyeonggiListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSeaGyeongnamListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSeaIncheonListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSeaJejuListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSeaJeonbugListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSeaJeonnamListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSeaSejongListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSeaSeoulListPage(int pageNum)throws Exception;

    Page<TripDto> selectTripSeaUlsanListPage(int pageNum)throws Exception;

    void insertMyLike(HashMap<String, Object> map)throws Exception;

    void deleteMyLike(HashMap<String, Object> map)throws Exception;
}
