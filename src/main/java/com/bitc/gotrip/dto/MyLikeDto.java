package com.bitc.gotrip.dto;

import lombok.Data;

@Data
public class MyLikeDto {
    private int likePk;
    private int tripPk;
    private String memberId;
}
