package com.pal.design.pattern.adapter.processor;

import com.pal.design.pattern.adapter.request.PaymentRequest;
import com.pal.design.pattern.adapter.response.PaymentResponse;

public interface PaymentProcessor {

    PaymentResponse processPayment(PaymentRequest paymentRequest);
}
