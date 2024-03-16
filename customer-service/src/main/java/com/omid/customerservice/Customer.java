package com.omid.customerservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String city;

    public Customer() {
        this.id = UUID.randomUUID().toString();
    }
}
