package com.ecommerce.product.response;

import lombok.Data;

@Data
public class ProductResponse<T> {

    private String message;
    private String error;
    private T data;



    public ProductResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public ProductResponse(String message, T data, String error) {
        this.message = message;
        this.data = data;
        this.error = error;
    }
}
