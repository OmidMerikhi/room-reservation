package com.omid.reservationservice;

import lombok.Data;

@Data
public class Room {
    private String id;
    private String title;
    private Integer floor;
    private RoomType type;
    private Long price;
    private Boolean status;
}
