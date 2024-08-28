package com.pal.design.pattern.adapter.thirdparty.response;

public record PayPalPaymentResponse(boolean isSuccess, Long transactionId) {

    public PayPalPaymentResponse {
        if (transactionId < 0) {
            throw new IllegalArgumentException("Transaction Id cannot be negative");
        }
    }
}
