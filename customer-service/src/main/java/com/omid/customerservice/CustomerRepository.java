package com.omid.customerservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String>, QuerydslPredicateExecutor<Customer> {
    Customer getCustomerById(String id);
}
