package com.omid.customerservice;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<CustomerDto, Customer> {
    CustomerDto toViewModel(Customer entity);
    Customer toEntity(CustomerDto viewModel);

}
