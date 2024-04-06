package com.omid.reservationservice.reservation;

import lombok.Data;

@Data
public class Guest {
    private String id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String phoneNumber;
    private String city;
    private PersonType personType;
}
