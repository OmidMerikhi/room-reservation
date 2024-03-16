package com.omid.roomservice;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Room {
    @Id
    private String id;
    private String title;
    private Integer floor;
    @Enumerated(EnumType.STRING)
    private RoomType type;
    private Long price;
    private Boolean status;

    public Room() {
        this.id = UUID.randomUUID().toString();
    }
}
