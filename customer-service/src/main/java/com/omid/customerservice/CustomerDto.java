package com.omid.customerservice;

import lombok.Data;

@Data
public class CustomerDto {
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String city;
}
