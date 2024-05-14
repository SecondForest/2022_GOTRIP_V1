package com.bitc.gotrip.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReserveDto {
    private int reservePk;
    private int tripPk;
    private String memberId;
    private String reserveStatus;
    private String reserveDate;
    private String reserveStart;
    private String reserveEnd;
    private int reserveCount;
    private int reservePrice;
    private String userName;
    private String userPhone;
    private String tripName;
    private int tripRegionPk;
    private int tripCategoryPk;

    private List<FileDto> fileList;
}
