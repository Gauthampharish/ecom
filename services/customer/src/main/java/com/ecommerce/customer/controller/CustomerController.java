package com.ecommerce.customer.controller;


import com.ecommerce.customer.dto.CustomerDto;
import com.ecommerce.customer.responses.CustomerResponse;
import com.ecommerce.customer.responses.CustomerResponseMessage;
import com.ecommerce.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse<CustomerDto>> createCustomer(@Valid @RequestBody CustomerDto customerdto) {
        CustomerDto customer = customerService.createCustomer(customerdto);
        CustomerResponse<CustomerDto> response = new CustomerResponse<>(CustomerResponseMessage.CUSTOMER_CREATED_SUCCESSFULLY.getMessage(), customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse<CustomerDto>> getCustomer(@PathVariable String id) {
        CustomerDto customer = customerService.getCustomer(id);
        CustomerResponse<CustomerDto> response = new CustomerResponse<>(CustomerResponseMessage.CUSTOMER_RETRIEVED_SUCCESSFULLY.getMessage(), customer);
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse<CustomerDto>> updateCustomer(@PathVariable String id, @Valid @RequestBody CustomerDto customerdto) {
        CustomerDto customer = customerService.updateCustomer(id, customerdto);
        CustomerResponse<CustomerDto> response = new CustomerResponse<>(CustomerResponseMessage.CUSTOMER_UPDATED_SUCCESSFULLY.getMessage(), customer);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public  ResponseEntity<CustomerResponse<List<CustomerDto>>>listCustomers(){
        List<CustomerDto> customers = customerService.listCustomers();
        CustomerResponse<List<CustomerDto>> response = new CustomerResponse<>(CustomerResponseMessage.CUSTOMERS_RETRIEVED_SUCCESSFULLY.getMessage(), customers);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
