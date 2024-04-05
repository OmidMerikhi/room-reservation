package com.omid.guestservice;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Guest {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String phoneNumber;
    private String city;
    private PersonType personType;

}
