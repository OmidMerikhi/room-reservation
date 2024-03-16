package com.omid.reservationservice;

import lombok.Data;

@Data
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String city;
}
