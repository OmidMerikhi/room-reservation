package com.omid.customerservice;

import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final QCustomer qCustomer=QCustomer.customer;

    public Customer loadOne(String id){
        return customerRepository.getCustomerById(id);
    }

    public List<Customer> loadAll(){
        return customerRepository.findAll();
    }

    public Customer create(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer update(String id, Customer customer){
        Customer dbCustomer=loadOne(id);

        if(customer.getFirstName()!=null){
            dbCustomer.setFirstName(customer.getFirstName());
        }
        if(customer.getLastName()!=null){
            dbCustomer.setLastName(customer.getLastName());
        }
        if(customer.getNationalCode()!=null){
            dbCustomer.setNationalCode(customer.getNationalCode());
        }
        if(customer.getCity()!=null){
            dbCustomer.setCity(customer.getCity());
        }

        return customerRepository.saveAndFlush(dbCustomer);

    }

    public Page<Customer> search(CustomerSearchFilter searchFilter, Pageable pageable){
        BooleanBuilder predicate=new BooleanBuilder();

        if(searchFilter.getFirstName()!=null){
            predicate.and(qCustomer.firstName.contains(searchFilter.getFirstName()));
        }

        if(searchFilter.getLastName()!=null){
            predicate.and(qCustomer.lastName.contains(searchFilter.getLastName()));
        }

        if(searchFilter.getNationalCode()!=null){
            predicate.and(qCustomer.nationalCode.contains(searchFilter.getNationalCode()));
        }

        if(searchFilter.getCity()!=null){
            predicate.and(qCustomer.city.contains(searchFilter.getCity()));
        }

        return customerRepository.findAll(predicate, pageable);
    }


}
