package com.pal.design.pattern.adapter.thirdparty.service;

import com.pal.design.pattern.adapter.thirdparty.request.PaypalPaymentRequest;
import com.pal.design.pattern.adapter.thirdparty.response.PayPalPaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PayPalService {

    private static final Logger log = LoggerFactory.getLogger(PayPalService.class);

    public PayPalPaymentResponse processPayment(PaypalPaymentRequest paypalPaymentRequest) {
        log.debug("Processing PayPal payment request: {}", paypalPaymentRequest);
        return new PayPalPaymentResponse(true, (long) new Random().nextInt(1000));
    }
}
