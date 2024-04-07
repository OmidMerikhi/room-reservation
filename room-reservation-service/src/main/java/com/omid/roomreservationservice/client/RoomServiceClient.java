package com.omid.roomreservationservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@FeignClient(name = "room-service", path = "/api/rooms", fallback = RoomServiceFallback.class)
public interface RoomServiceClient {
    @GetMapping
    List<Room> getAllRooms();

    @GetMapping("/{id}")
    Room getRoomById(@PathVariable String id);

    @PostMapping
    Room createRoom(@RequestBody Room room);

    @PutMapping("/{id}")
    Room updateRoom(@PathVariable String id, @RequestBody Room room);

    @GetMapping("/search")
    Page<Room> search(RoomSearchFilter searchFilter, Pageable pageable);
}
