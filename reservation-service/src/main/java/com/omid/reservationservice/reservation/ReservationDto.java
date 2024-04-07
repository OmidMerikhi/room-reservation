package com.omid.reservationservice.reservation;

import lombok.Data;

import java.text.DecimalFormat;

@Data
public class ReservationDto {
    private String id;
    private Guest guest;
    private Room room;
    private String price;
    private String from;
    private String to;
    private String totalPrice;

    public ReservationDto(Reservation reservation) {
        DecimalFormat df=new DecimalFormat("###,###");
        this.id = reservation.getId();
        this.guest = reservation.getGuest();
        this.room = reservation.getRoom();
        this.price = df.format(reservation.getPrice());
        this.totalPrice = df.format(reservation.getTotalPrice());
    }
}
