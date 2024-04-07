package com.omid.roomreservationservice.client;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Reservation {
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
