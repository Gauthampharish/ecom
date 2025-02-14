package com.ecommerce.customer.responses;

import lombok.Data;

@Data
public class CustomerResponse<T> {

    private String message;
    private String error;
    private T data;

    public CustomerResponse(String message) {
        this.message = message;
    }

    public CustomerResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public CustomerResponse(String message, T data, String error) {
        this.message = message;
        this.data = data;
        this.error = error;
    }
}