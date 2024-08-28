package com.pal.design.pattern.adapter.response;

public record PaymentResponse(boolean isSuccess, Long transactionId) {

    public PaymentResponse {
        if (transactionId < 0) {
            throw new IllegalArgumentException("Transaction Id cannot be negative");
        }
    }
}

