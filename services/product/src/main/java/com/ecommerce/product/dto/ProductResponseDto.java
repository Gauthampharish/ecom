package com.ecommerce.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponseDto {

     private Long id;
    private String name;

    private String description;

    private double availableQuantity;

    private BigDecimal price;

    private  Long categoryId;

    private String categoryName;

    private String categoryDescription;


}
