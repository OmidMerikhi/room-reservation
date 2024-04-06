package com.omid.reservationservice.reservation;

import ir.huri.jcal.JalaliCalendar;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.loadAllReservations();
    }

    @GetMapping("/search")
    public List<Reservation> search(@RequestParam("from") JalaliCalendar from,
                                    @RequestParam("to") JalaliCalendar to) {
        return reservationService.searchReservation(from,to);
    }

    @PostMapping
    public Reservation createReservation(@RequestParam("guest-id") String guestId,
                                         @RequestParam("room-id") String roomId,
                                         @RequestParam("from") String from,
                                         @RequestParam("to") String to) {
        return reservationService.createReservation(guestId, roomId, from, to);
    }
}
