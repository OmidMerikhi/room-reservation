package com.omid.reservationservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceFallBack implements CustomerServiceClient {
    @Override
    public List<Customer> loadAllCustomer() {
        return new ArrayList<>();
    }

    @Override
    public Customer loadById(String id) {
        return new Customer();
    }
}
