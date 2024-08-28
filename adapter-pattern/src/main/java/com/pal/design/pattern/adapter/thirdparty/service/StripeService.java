package com.pal.design.pattern.adapter.thirdparty.service;

import com.pal.design.pattern.adapter.thirdparty.request.StripePaymentRequest;
import com.pal.design.pattern.adapter.thirdparty.response.StripePaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

    private static final Logger log = LoggerFactory.getLogger(StripeService.class);

    public StripePaymentResponse processPayment(StripePaymentRequest stripePaymentRequest) {
        log.debug("Processing Stripe payment request: {}", stripePaymentRequest);
        return new StripePaymentResponse(true, (long) 1000);
    }
}
