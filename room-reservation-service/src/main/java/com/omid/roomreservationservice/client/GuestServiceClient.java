package com.omid.roomreservationservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@FeignClient(name = "guest-service", path = "/api/guests", fallback = GuestServiceFallback.class)
public interface GuestServiceClient {

    @GetMapping
    List<Guest> loadAllGuest();

    @GetMapping("/load-one")
    Guest loadOneGuest(@RequestParam("id") String id);

    @GetMapping("/search")
    List<Guest> searchGuest(@RequestParam("value") String value);

    @PostMapping
    Guest createGuest(@RequestBody Guest guest);

    @PutMapping("/{id}")
    Guest updateGuest(@PathVariable("id") String id, @RequestBody Guest guest);
}

