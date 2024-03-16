package com.omid.reservationservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public Reservation create(@RequestParam("customer-national-code") String nationalCode,
                              @RequestParam("room-id") String roomId,
                              @RequestParam("from-date") Long fromDate,
                              @RequestParam("to-date") Long toDate) {
        return reservationService.create(nationalCode,roomId,fromDate,toDate);


    }

    @GetMapping
    public List<Reservation> loadAll(){
        return reservationService.loadAll();
    }


}
