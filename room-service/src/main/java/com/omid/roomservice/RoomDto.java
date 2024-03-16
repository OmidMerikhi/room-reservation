package com.omid.roomservice;

import lombok.Data;

@Data
public class RoomDto {
    private String title;
    private Integer floor;
    private RoomType type;
    private Long price;
    private Boolean status;
}
