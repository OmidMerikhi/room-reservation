package com.omid.reservationservice.reservation;

import ir.huri.jcal.JalaliCalendar;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;
//    private final ReservationMapper reservationMapper;

    private final Environment env;
    @GetMapping
    public List<ReservationDto> getAllReservations() {
        System.out.println(env.getProperty("local.server.port"));
        return reservationService.loadAllReservations();
    }

    @GetMapping("/search")
    public List<ReservationDto> search(@RequestParam("from") Long from,
                                       @RequestParam("to") Long to) {
        return reservationService.searchReservation(from,to);
    }

    @PostMapping
    public ReservationDto createReservation(@RequestParam("guest-id") String guestId,
                                         @RequestParam("room-id") String roomId,
                                         @RequestParam("from") Long from,
                                         @RequestParam("to") Long to) {
        return reservationService.createReservation(guestId, roomId, from, to);
    }
}
