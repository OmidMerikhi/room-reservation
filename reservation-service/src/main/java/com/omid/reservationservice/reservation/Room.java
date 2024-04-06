package com.omid.reservationservice.reservation;

import lombok.Data;

@Data
public class Room {
    private String id;
    private String title;
    private String reserveInfo;
    private Boolean active;
    private Boolean vacancy;
    private RoomType roomType;
}
