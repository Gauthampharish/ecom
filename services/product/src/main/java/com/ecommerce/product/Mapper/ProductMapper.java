package com.ecommerce.product.Mapper;

import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.dto.ProductPurchaseDto;
import com.ecommerce.product.dto.ProductPurchaseResponseDto;
import com.ecommerce.product.dto.ProductResponseDto;
import com.ecommerce.product.models.Category;
import com.ecommerce.product.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .availableQuantity(product.getAvailableQuantity())
                .description(product.getDescription())

                .build();
    }

    public List<ProductDto> toDtos(List<Product> products) {
        return products.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Product toEntity(ProductDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .category(Category.builder().id(productDto.getCategoryId()).build())
                .description(productDto.getDescription())
                .availableQuantity(productDto.getAvailableQuantity())
                .build();
    }

    public ProductResponseDto toResponseDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .availableQuantity(product.getAvailableQuantity())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .categoryDescription(product.getCategory().getDescription())
                .build();
    }

    public ProductPurchaseDto toPurchaseDto(Product product) {
        return ProductPurchaseDto.builder()
                .id(product.getId())

                .quantity(product.getAvailableQuantity())
                .build();
    }

    public List<ProductPurchaseDto> toPurchaseDtos(List<Product> products) {
        return products.stream()
                .map(this::toPurchaseDto)
                .collect(Collectors.toList());
    }

    public  long getProductId(ProductPurchaseDto productPurchaseDto){
        return productPurchaseDto.getId();
    }

    public List<Long> getProductIds(List<ProductPurchaseDto> productPurchaseDtos){
        return productPurchaseDtos.stream()
                .map(this::getProductId)
                .collect(Collectors.toList());
    }

    public ProductPurchaseResponseDto toPurchaseResponseDto(Product product, double quantity) {
        return ProductPurchaseResponseDto.builder()
                .productId(product.getId())
                .quantity(quantity)
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }
}