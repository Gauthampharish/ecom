package com.ecommerce.product.controller;


import com.ecommerce.product.dto.ProductPurchaseDto;
import com.ecommerce.product.dto.ProductPurchaseResponseDto;
import com.ecommerce.product.dto.ProductResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.response.ProductResponse;
import com.ecommerce.product.response.ProductResponseMessage;
import com.ecommerce.product.service.ProductService;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

        @PostMapping
        public ResponseEntity<ProductResponse<ProductResponseDto>> createProduct(@Valid @RequestBody ProductDto productDto) {
    ProductResponseDto productResponseDto = productService.createProduct(productDto);
    ProductResponse<ProductResponseDto> response = new ProductResponse<>(ProductResponseMessage.PRODUCT_CREATED_SUCCESSFULLY.getMessage(), productResponseDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
}


       @PostMapping("/purchase")
public ResponseEntity<ProductResponse<List<ProductPurchaseResponseDto>>> purchaseProduct(@Valid @RequestBody List<ProductPurchaseDto> productPurchaseDto) {
    List<ProductPurchaseResponseDto> productPurchases = productService.purchaseProduct(productPurchaseDto);
    ProductResponse<List<ProductPurchaseResponseDto>> response = new ProductResponse<>(ProductResponseMessage.PRODUCT_PURCHASED_SUCCESSFULLY.getMessage(), productPurchases);
    return ResponseEntity.status(HttpStatus.OK).body(response);
}

        @GetMapping("/{product_id}")
        public ResponseEntity<ProductResponse<ProductDto>> getProduct(@PathVariable("product_id") Long productId) {
            ProductDto product = productService.getProduct(productId);
            ProductResponse<ProductDto> response = new ProductResponse<>(ProductResponseMessage.PRODUCT_RETRIEVED_SUCCESSFULLY.getMessage(), product);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        @GetMapping
        public ResponseEntity<ProductResponse<List<ProductDto>>> getAllProducts() {
            List<ProductDto> products = productService.getAllProducts();
            ProductResponse<List<ProductDto>> response = new ProductResponse<>(ProductResponseMessage.PRODUCT_RETRIEVED_SUCCESSFULLY.getMessage(), products);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

}
