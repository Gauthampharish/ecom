package com.ecommerce.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String description;

    private double availableQuantity;
    @NotNull
    private BigDecimal price;

    private  Long categoryId;



}
