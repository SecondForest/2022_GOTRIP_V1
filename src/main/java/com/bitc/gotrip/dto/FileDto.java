package com.bitc.gotrip.dto;

import lombok.Data;

import java.util.List;

@Data
public class FileDto {
    private int filePk;
    private int tableNum;
    private int pkNum;
    private String originalFileName;
    private String storedFilePath;
    private long fileSize;
    private String deletedYn;

    private List<TripDto> tripList;
}
