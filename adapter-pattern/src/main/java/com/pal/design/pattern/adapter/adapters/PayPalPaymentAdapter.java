package com.pal.design.pattern.adapter.adapters;

import com.pal.design.pattern.adapter.processor.PaymentProcessor;
import com.pal.design.pattern.adapter.request.PaymentRequest;
import com.pal.design.pattern.adapter.response.PaymentResponse;
import com.pal.design.pattern.adapter.thirdparty.request.PaypalPaymentRequest;
import com.pal.design.pattern.adapter.thirdparty.response.PayPalPaymentResponse;
import com.pal.design.pattern.adapter.thirdparty.service.PayPalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PayPalPaymentAdapter implements PaymentProcessor {

    private static final Logger log = LoggerFactory.getLogger(PayPalPaymentAdapter.class);

    private final PayPalService payPalService;

    public PayPalPaymentAdapter(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    /**
     * Process payment using PayPal payment gateway
     *
     * @param paymentRequest payment request
     * @return payment response
     */
    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        log.debug("Processing PayPal payment request: {}", paymentRequest);
        PaypalPaymentRequest paypalPaymentRequest = constructRequest(paymentRequest);
        PayPalPaymentResponse payPalPaymentResponse = payPalService.processPayment(paypalPaymentRequest);
        return constructPaymentResponse(payPalPaymentResponse);
    }

    private PaypalPaymentRequest constructRequest(PaymentRequest paymentRequest) {
        return new PaypalPaymentRequest(paymentRequest.amount(), paymentRequest.currency());
    }

    private PaymentResponse constructPaymentResponse(PayPalPaymentResponse payPalPaymentResponse) {
        return new PaymentResponse(payPalPaymentResponse.isSuccess(), payPalPaymentResponse.transactionId());
    }
}
