package com.bitc.gotrip.service;

import com.bitc.gotrip.common.FileUtils;
import com.bitc.gotrip.dto.FileDto;
import com.bitc.gotrip.dto.TripDto;
import com.bitc.gotrip.mapper.TripMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.HashMap;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripMapper tripMapper;

    @Autowired
    private FileUtils fileUtils;


    @Override
    public List<TripDto> selectTripList() throws Exception {
        return tripMapper.selectTripList();
    }

    @Override
    public void insertTrip(int tripCategoryPk, int tripRegionPk, String tripName, int tripPrice, String tripContents, Double tripLatitude, Double tripHardness) throws Exception {
        TripDto trip = new TripDto();
        trip.setTripCategoryPk(tripCategoryPk);
        trip.setTripRegionPk(tripRegionPk);
        trip.setTripName(tripName);
        trip.setTripPrice(tripPrice);
        trip.setTripContents(tripContents);
        trip.setTripLatitude(tripLatitude);
        trip.setTripHardness(tripHardness);

        tripMapper.insertTrip(trip);
    }

    @Override
    public void insertTrip(TripDto trip, MultipartHttpServletRequest multiUploadFiles) throws Exception {
        tripMapper.insertTrip(trip);

        List<FileDto> fileList = fileUtils.parseFileInfo(0, trip.getPkNum(), multiUploadFiles);

        if (CollectionUtils.isEmpty(fileList) == false) {
            tripMapper.insertFileList(fileList);
        }

    }

    @Override
    public List<FileDto> selectFileList() throws Exception {
        return tripMapper.selectFileList();
    }

    @Override
    public TripDto selectTripDetail(int pkNum) throws Exception {
        tripMapper.updateHitCnt(pkNum);
        TripDto trip = tripMapper.selectTripDetail(pkNum);
        List<FileDto> fileList = tripMapper.selectTripFileList(pkNum);
        trip.setFileList(fileList);
        return trip;
    }

    @Override
    public List<FileDto> selectFileDetail(int pkNum) throws Exception {
        List<FileDto> files = tripMapper.selectFileDetail(pkNum);
//        List<TripDto> tripList = tripMapper.selectTripDetailList(tripPk);

        for (FileDto file : files) {
            List<TripDto> tripList = tripMapper.selectTripDetailList(pkNum);

            file.setTripList(tripList);
        }

//        files.setTripList(tripList);

        return files;
    }

    @Override
    public void deleteTrip(int pkNum) throws Exception {
        tripMapper.deleteTrip(pkNum);
    }

    @Override
    public void tripUpdate(TripDto trip, MultipartHttpServletRequest multiUploadFiles) throws Exception {
        tripMapper.tripUpdate(trip);

        List<FileDto> fileList = fileUtils.parseFileInfo(0, trip.getPkNum(), multiUploadFiles);
        if (CollectionUtils.isEmpty(fileList) == false) {
            tripMapper.insertFileList(fileList);
        }

    }

    @Override
    public Page<TripDto> selectTripListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouBusanListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouBusanListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouChungbugListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouChungbugListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouChungnamListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouChungnamListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouDaeguListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouDaeguListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouDaejeonListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouDaejeonListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouGangwonListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouGangwonListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouGwangjuListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouGwangjuListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouGyeongbugListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouGyeongbugListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouGyeonggiListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouGyeonggiListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouGyeongnamListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouGyeongnamListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouIncheonListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouIncheonListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouJejuListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouJejuListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouJeonbugListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouJeonbugListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouJeonnamListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouJeonnamListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouSejongListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouSejongListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouSeoulListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouSeoulListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripMouUlsanListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripMouUlsanListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyBusanListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyBusanListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyChungbugListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyChungbugListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyChungnamListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyChungnamListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyDaeguListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyDaeguListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyDaejeonListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyDaejeonListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyGangwonListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyGangwonListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyGwangjuListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyGwangjuListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyGyeongbugListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyGyeongbugListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyGyeonggiListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyGyeonggiListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyGyeongnamListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyGyeongnamListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyIncheonListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyIncheonListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyJejuListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyJejuListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyJeonbugListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyJeonbugListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyJeonnamListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyJeonnamListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkySejongListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkySejongListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkySeoulListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkySeoulListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSkyUlsanListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSkyUlsanListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaBusanListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaBusanListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaChungbugListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaChungbugListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaChungnamListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaChungnamListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaDaeguListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaDaeguListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaDaejeonListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaDaejeonListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaGangwonListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaGangwonListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaGwangjuListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaGwangjuListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaGyeongbugListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaGyeongbugListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaGyeonggiListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaGyeonggiListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaGyeongnamListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaGyeongnamListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaIncheonListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaIncheonListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaJejuListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaJejuListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaJeonbugListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaJeonbugListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaJeonnamListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaJeonnamListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaSejongListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaSejongListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaSeoulListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaSeoulListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public Page<TripDto> selectTripSeaUlsanListPage(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 3);


        Page<TripDto> dataList = tripMapper.selectTripSeaUlsanListPage();

        for (TripDto item : dataList) {
            List<FileDto> fileList = selectThumFileList(item.getPkNum());

            item.setFileList(fileList);
        }

        return dataList;
    }

    @Override
    public void insertMyLike(HashMap<String, Object> map) throws Exception {
        tripMapper.insertMyLike(map);
    }

    @Override
    public void deleteMyLike(HashMap<String, Object> map) throws Exception {
        tripMapper.deleteMyLike(map);
    }


    @Override
    public List<FileDto> selectThumFileList(int pkNum) throws Exception {
        return tripMapper.selectThumFileList(pkNum);
    }

    @Override
    public void updateTripFile(int filePk) throws Exception {
        tripMapper.deleteFileByFilePk(filePk);
    }
}
