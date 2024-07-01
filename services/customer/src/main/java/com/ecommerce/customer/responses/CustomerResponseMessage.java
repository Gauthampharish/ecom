package com.ecommerce.customer.responses;

public enum CustomerResponseMessage {
    CUSTOMER_CREATED_SUCCESSFULLY("Customer created successfully"),
    CUSTOMER_UPDATED_SUCCESSFULLY("Customer updated successfully"),
    CUSTOMER_DELETED_SUCCESSFULLY("Customer deleted successfully"),
    CUSTOMER_RETRIEVED_SUCCESSFULLY("Customer retrieved successfully"),
    CUSTOMERS_RETRIEVED_SUCCESSFULLY("Customers retrieved successfully"),
    CUSTOMER_NOT_FOUND("Customer not found"),
    CUSTOMER_ALREADY_EXISTS("Customer already exists"),
    CUSTOMER_NOT_CREATED("Customer not created"),
    CUSTOMER_NOT_UPDATED("Customer not updated"),
    CUSTOMER_NOT_DELETED("Customer not deleted"),

    CUSTOMER_NOT_RETRIEVED("Customer not retrieved"),
    CUSTOMERS_NOT_RETRIEVED("Customers not retrieved");

    private final String message;

    CustomerResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
