package com.ecommerce.product.exceptions;

import com.ecommerce.product.response.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.InvalidPropertiesFormatException;
import java.util.NoSuchElementException;

@Component
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ProductResponse<String>> handleNoSuchElementException(NoSuchElementException e) {
        ProductResponse<String> response = new ProductResponse<>(e.getMessage(),null, e.getClass().getName());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ProductResponse<String>> handleException(Exception e) {
        ProductResponse<String> response = new ProductResponse<>(e.getMessage(),null, e.getClass().getName());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ProductResponse<String>> handleRuntimeException(RuntimeException e) {
        ProductResponse<String> response = new ProductResponse<>(e.getMessage(),null, e.getClass().getName());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ProductResponse<String>> handleInvalidPropertiesFormatException(InvalidPropertiesFormatException e) {
        ProductResponse<String> response = new ProductResponse<>(e.getMessage(),null, e.getClass().getName());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}


