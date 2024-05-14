package com.bitc.gotrip.dto;

import lombok.Data;

import java.util.List;

@Data
public class TripDto {
    private int pkNum;
    private int tripCategoryPk;
    private int tripRegionPk;
    private String tripName;
    private int tripPrice;
    private String tripContents;
    private double tripLatitude;
    private double tripHardness;
    private String tripCreate;
    private String tripUpdate;
    private String deletedYn;
    private int hitCnt;

    private List<FileDto> fileList;
}
