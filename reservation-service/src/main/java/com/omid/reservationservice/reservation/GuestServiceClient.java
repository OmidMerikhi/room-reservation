package com.omid.reservationservice.reservation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(name = "guest-service", path = "/api/guests", fallback = GuestServiceFallback.class)
public interface GuestServiceClient {
    @GetMapping
    public List<Guest> loadAllGuest();

    @GetMapping("/load-one")
    public Guest loadGuestById(@RequestParam("id") String id);
}
