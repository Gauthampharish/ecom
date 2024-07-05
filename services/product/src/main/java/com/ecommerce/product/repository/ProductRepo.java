package com.ecommerce.product.repository;

import com.ecommerce.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findAllByIdInOrderById(List<Long> ids);
}
