package com.omid.roomreservationservice.client;

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

}
