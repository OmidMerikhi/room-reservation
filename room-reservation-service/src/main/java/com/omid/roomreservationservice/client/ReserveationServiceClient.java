package com.omid.roomreservationservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(name = "reservation-service", path = "/api/reservations", fallback = ReservationFallback.class)
public interface ReserveationServiceClient {
    @GetMapping
    List<ReservationDto> getAllReservations();

    @GetMapping("/search")
    List<ReservationDto> search(@RequestParam("from") Long from,
                                @RequestParam("to") Long to);

    @PostMapping
    ReservationDto createReservation(@RequestParam("guest-id") String guestId,
                                     @RequestParam("room-id") String roomId,
                                     @RequestParam("from") Long from,
                                     @RequestParam("to") Long to);
}
