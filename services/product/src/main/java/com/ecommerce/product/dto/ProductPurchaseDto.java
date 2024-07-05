package com.ecommerce.product.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductPurchaseDto {
    @NotNull
    private Long id;
    @Positive @NotNull
    private  double quantity;
}
