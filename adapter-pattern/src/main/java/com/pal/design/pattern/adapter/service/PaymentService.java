package com.pal.design.pattern.adapter.service;

import com.pal.design.pattern.adapter.processor.PaymentProcessor;
import com.pal.design.pattern.adapter.request.PaymentRequest;
import com.pal.design.pattern.adapter.response.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final Map<String, PaymentProcessor> paymentProcessors;

    public PaymentService(List<PaymentProcessor> processors) {
        this.paymentProcessors = processors.stream()
                .collect(Collectors.toMap(processor -> processor.getClass().getSimpleName(), Function.identity()));
    }

    public PaymentResponse processPayment(String gateway, PaymentRequest request) {
        PaymentProcessor paymentProcessor = paymentProcessors.get(gateway + "PaymentAdapter");
        if (paymentProcessor == null) {
            throw new IllegalArgumentException("Unsupported payment gateway: " + gateway);
        }
        return paymentProcessor.processPayment(request);
    }
}
