package com.omid.reservationservice.reservation;

import lombok.Getter;

@Getter
public enum RoomType {
    SINGLE("یک نفره (تخت یک نفره)"),
    DOUBLE("دو نفره (تخت دو نفره)"),
    TWIN("دو نفره (تخت مجزا)"),
    TRIPLE("سه نفره"),
    QUAD("چهار نفره");
    final String value;
    RoomType(String value){
        this.value=value;
    }
}
