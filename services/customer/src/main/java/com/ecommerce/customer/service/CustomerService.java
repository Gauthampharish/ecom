package com.ecommerce.customer.service;

import com.ecommerce.customer.dto.CustomerDto;
import com.ecommerce.customer.mapper.CustomerMapper;
import com.ecommerce.customer.model.Customer;
import com.ecommerce.customer.repository.CustomerRepo;
import com.ecommerce.customer.responses.CustomerResponseMessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {

    private final CustomerRepo customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepository = customerRepo;
        this.customerMapper = customerMapper;
    }

    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toDto(savedCustomer);
    }

    public CustomerDto getCustomer(String id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NoSuchElementException(CustomerResponseMessage.CUSTOMER_NOT_FOUND.getMessage()));
        return customerMapper.toDto(customer);
    }

    public CustomerDto updateCustomer(String id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NoSuchElementException(CustomerResponseMessage.CUSTOMER_NOT_FOUND.getMessage()));
        Customer updatedCustomer = Customer.builder()
            .firstname(customerDto.getFirstName())
            .lastname(customerDto.getLastName())
            .email(customerDto.getEmail())
            .build();

        Customer savedCustomer = customerRepository.save(updatedCustomer);
        return customerMapper.toDto(savedCustomer);
    }

    public List<CustomerDto> listCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.toDtos(customers);
    }
}