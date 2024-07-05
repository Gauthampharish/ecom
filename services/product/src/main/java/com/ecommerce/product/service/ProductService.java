package com.ecommerce.product.service;

import com.ecommerce.product.Mapper.ProductMapper;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.dto.ProductPurchaseDto;
import com.ecommerce.product.dto.ProductPurchaseResponseDto;
import com.ecommerce.product.dto.ProductResponseDto;
import com.ecommerce.product.models.Product;
import com.ecommerce.product.repository.ProductRepo;
import com.ecommerce.product.response.ProductResponseMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public ProductResponseDto createProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product savedProduct = productRepo.save(product);
        return productMapper.toResponseDto(savedProduct);
    }

    public ProductResponseDto updateProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product savedProduct = productRepo.save(product);
        return productMapper.toResponseDto(savedProduct);
    }

    @Transactional
    public List<ProductPurchaseResponseDto> purchaseProduct(List<ProductPurchaseDto> productPurchaseDtos) {
        List<Long> productIds = productMapper.getProductIds(productPurchaseDtos);
        List<Product> products = productRepo.findAllByIdInOrderById(productIds);

        if (products.size() != productIds.size()) {
            throw new NoSuchElementException("Invalid product ID");
        }

        List<ProductPurchaseResponseDto> purchasedProducts = new ArrayList<>();
        for (Product product : products) {
            double quantity = productPurchaseDtos.stream()
                    .filter(dto -> dto.getId().equals(product.getId()))
                    .findFirst()
                    .map(ProductPurchaseDto::getQuantity)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

          if (product.getAvailableQuantity() < quantity) {
    throw new IllegalArgumentException("Product is out of stock");
}
            product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
            purchasedProducts.add(productMapper.toPurchaseResponseDto(product, quantity));
        }

        productRepo.saveAll(products); // Save all at once
        return purchasedProducts;
    }

    public ProductDto getProduct(Long id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new NoSuchElementException(ProductResponseMessage.PRODUCT_NOT_FOUND.getMessage()));
        return productMapper.toDto(product);
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return productMapper.toDtos(products);
    }
}