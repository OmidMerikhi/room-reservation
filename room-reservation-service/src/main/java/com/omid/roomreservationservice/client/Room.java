package com.omid.roomreservationservice.client;

import lombok.Data;

import java.util.UUID;

@Data
public class Room {
    private String id;
    private String title;
    private String reserveInfo;
    private Boolean active;
    private Boolean vacancy;
    private RoomType roomType;

}
