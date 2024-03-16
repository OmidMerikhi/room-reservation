package com.omid.reservationservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name = "room-service", path = "/api/rooms", fallback = RoomFallBack.class)
public interface RoomServiceClient {
    @GetMapping
    List<Room> loadAllRoom();

    @GetMapping("/{id}")
    Room loadById(@PathVariable("id") String id);


}
