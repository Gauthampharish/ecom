package com.ecommerce.customer.controller;


import com.ecommerce.customer.dto.CustomerDto;
import com.ecommerce.customer.responses.CustomerResponse;
import com.ecommerce.customer.responses.CustomerResponseMessage;
import com.ecommerce.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerDto customerdto) {
        CustomerDto customer = customerService.createCustomer(customerdto);
        CustomerResponse response = new CustomerResponse(CustomerResponseMessage.CUSTOMER_CREATED_SUCCESSFULLY.getMessage(), customer);
        return ResponseEntity.ok(response);
    }

}
