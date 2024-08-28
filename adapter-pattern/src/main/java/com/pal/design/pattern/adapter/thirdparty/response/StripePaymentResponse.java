package com.pal.design.pattern.adapter.thirdparty.response;

public record StripePaymentResponse(boolean isSuccess, Long transactionId) {

    public StripePaymentResponse {
        if (transactionId < 0) {
            throw new IllegalArgumentException("Transaction Id cannot be negative");
        }
    }
}
