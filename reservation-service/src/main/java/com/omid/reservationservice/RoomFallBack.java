package com.omid.reservationservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomFallBack implements RoomServiceClient {
    @Override
    public List<Room> loadAllRoom() {
        return new ArrayList<>();
    }

    @Override
    public Room loadById(String id) {
        return new Room();
    }
}
