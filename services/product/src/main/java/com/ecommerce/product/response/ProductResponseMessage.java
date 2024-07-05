package com.ecommerce.product.response;

public enum ProductResponseMessage {
    PRODUCT_CREATED_SUCCESSFULLY("Product created successfully"),
    PRODUCT_UPDATED("Product updated successfully"),
    PRODUCT_DELETED("Product deleted successfully"),
    PRODUCT_RETRIEVED_SUCCESSFULLY("Product retrieved successfully"),
    PRODUCT_NOT_FOUND("Product not found"),
    PRODUCT_ALREADY_EXISTS("Product already exists"),
    PRODUCT_QUANTITY_NOT_AVAILABLE("Product quantity not available"),
    PRODUCT_PURCHASED_SUCCESSFULLY("Product purchased successfully");

    private final String message;

    ProductResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
