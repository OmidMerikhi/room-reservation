package com.omid.roomreservationservice.client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceFallback implements RoomServiceClient {
    @Override
    public List<Room> getAllRooms() {
        return new ArrayList<>();
    }

    @Override
    public Room getRoomById(String id) {
        return new Room();
    }

    @Override
    public Room createRoom(Room room) {
        return new Room();
    }

    @Override
    public Room updateRoom(String id, Room room) {
        return new Room();
    }

    @Override
    public Page<Room> search(RoomSearchFilter searchFilter, Pageable pageable) {
        return null;
    }
}
