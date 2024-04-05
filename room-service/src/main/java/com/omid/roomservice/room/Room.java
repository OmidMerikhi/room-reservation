package com.omid.roomservice.room;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Room {
    @Id
    private String id;
    private String title;
    private String reserveInfo;
    private Boolean active;
    private Boolean vacancy;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    public Room() {
        this.id = UUID.randomUUID().toString();
    }
}
