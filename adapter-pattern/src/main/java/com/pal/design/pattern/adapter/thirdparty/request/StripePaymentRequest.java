package com.pal.design.pattern.adapter.thirdparty.request;

public record StripePaymentRequest(double amount, String currency) {
}
