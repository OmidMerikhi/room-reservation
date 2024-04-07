package com.omid.reservationservice.reservation;

import ir.huri.jcal.JalaliCalendar;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Reservation {
    @Id
    private String id;
    private Guest guest;
    private Room room;
    private Double price=400000d;
    private LocalDate from;
    private LocalDate to;
    private Double totalPrice;

    public Reservation() {
        this.id= UUID.randomUUID().toString();
    }

}
