package com.omid.reservationservice.reservation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name = "room-service", path = "/api/rooms")
public interface RoomServiceClient {
    @GetMapping
    List<Room> getAllRooms();

    @GetMapping("/{id}")
    Room getRoomById(@PathVariable String id);
}
