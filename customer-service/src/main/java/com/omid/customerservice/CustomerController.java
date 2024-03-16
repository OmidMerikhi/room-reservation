package com.omid.customerservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @GetMapping("/{id}")
    public Customer loadOne(@PathVariable("id") String id){
        return customerService.loadOne(id);
    }

    @GetMapping
    public List<CustomerDto> loadAll(){
        return customerMapper.toViewModel(customerService.loadAll());
    }

    @GetMapping("/search")
    public Page<Customer> search(CustomerSearchFilter searchFilter, Pageable pageable){
        return customerService.search(searchFilter,pageable);
    }

    @PostMapping
    public CustomerDto create(@RequestBody CustomerDto customerDto){
        return customerMapper.toViewModel(customerService.create(customerMapper.toEntity(customerDto)));
    }

    @PutMapping("/{id}")
    public CustomerDto update(@PathVariable("id") String id, @RequestBody CustomerDto customerDto){
        return customerMapper.toViewModel(customerService.update(id, customerMapper.toEntity(customerDto)));
    }

}
