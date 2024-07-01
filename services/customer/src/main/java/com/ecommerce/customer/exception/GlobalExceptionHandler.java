package com.ecommerce.customer.exception;

import com.ecommerce.customer.responses.CustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<CustomerResponse<String>> handleNoSuchElementException(NoSuchElementException e) {
        CustomerResponse<String> response = new CustomerResponse<>(e.getMessage(), null, e.getClass().getName());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CustomerResponse<String>> handleRuntimeException(RuntimeException e) {
        CustomerResponse<String> response = new CustomerResponse<>(e.getMessage(), null, e.getClass().getName());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomerResponse<String>> handleException(Exception e) {
        CustomerResponse<String> response = new CustomerResponse<>(e.getMessage(), null, e.getClass().getName());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}