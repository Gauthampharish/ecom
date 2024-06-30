package com.ecommerce.customer.mapper;

import com.ecommerce.customer.dto.CustomerDto;
import com.ecommerce.customer.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstname())
                .lastName(customer.getLastname())
                .email(customer.getEmail())
                .build();
    }

    public Customer toEntity(CustomerDto customerDto) {
        return Customer.builder()
                .firstname(customerDto.getFirstName())
                .lastname(customerDto.getLastName())
                .email(customerDto.getEmail())
                .build();
    }
}