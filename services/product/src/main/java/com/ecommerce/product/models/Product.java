package com.ecommerce.product.models;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;


@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}