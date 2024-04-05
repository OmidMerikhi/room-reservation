package com.omid.roomservice.room;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class RoomDto {
    private String title;
    private String reserveInfo;
    private Boolean active;
    private Boolean vacancy;
    private RoomType roomType;
}
