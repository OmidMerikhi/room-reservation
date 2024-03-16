package com.omid.customerservice;

import lombok.Data;

@Data
public class CustomerSearchFilter {
    private String id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String city;
}
