package com.omid.roomservice;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class RoomSearchFilter {
    private String id;
    private String title;
    private Integer floor;
    private RoomType type;
    private Long price;
    private Boolean status;
}
