package com.omid.roomservice.room;

import lombok.Data;

@Data
public class RoomSearchFilter {
    private String title;
    private String reserveInfo;
    private Boolean active;
    private Boolean vacancy;
    private RoomType roomType;

}
