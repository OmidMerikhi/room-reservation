package com.omid.reservationservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name = "customer-service", path = "/api/customers", fallback = CustomerServiceFallBack.class)
public interface CustomerServiceClient {
    @GetMapping
    List<Customer> loadAllCustomer();

    @GetMapping("/{id}")
    Customer loadById(@PathVariable("id") String id);

}
