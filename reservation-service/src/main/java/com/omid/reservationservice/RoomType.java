package com.omid.reservationservice;

import lombok.Getter;

@Getter
public enum RoomType {
    SINGLE_ROOM("یک تخته"),
    DOUBLE_ROOM("دو تخته"),
    TRIPLE_ROOM("سه تخته"),
    FOUR_ROOM("چهار تخته");

    private final String value;

    RoomType(String value){
        this.value=value;
    }
}
