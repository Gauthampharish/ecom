package com.ecommerce.product.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductPurchaseResponseDto {

      Long productId;
     double quantity;
     BigDecimal price;
     String description;

}
