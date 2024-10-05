package com.pal.design.pattern.adapter.adapters;

import com.pal.design.pattern.adapter.processor.PaymentProcessor;
import com.pal.design.pattern.adapter.request.PaymentRequest;
import com.pal.design.pattern.adapter.response.PaymentResponse;
import com.pal.design.pattern.adapter.thirdparty.request.StripePaymentRequest;
import com.pal.design.pattern.adapter.thirdparty.response.StripePaymentResponse;
import com.pal.design.pattern.adapter.thirdparty.service.StripeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StripePaymentAdapter implements PaymentProcessor {

    private static final Logger log = LoggerFactory.getLogger(StripePaymentAdapter.class);

    private final StripeService stripeService;

    public StripePaymentAdapter(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    /**
     * Process payment using Stripe payment gateway
     *
     * @param paymentRequest payment request
     * @return payment response
     */
    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        log.debug("Processing Stripe payment request: {}", paymentRequest);
        StripePaymentRequest stripePaymentRequest = constructRequest(paymentRequest);
        StripePaymentResponse stripePaymentResponse = stripeService.processPayment(stripePaymentRequest);
        return constructPaymentResponse(stripePaymentResponse);
    }

    private StripePaymentRequest constructRequest(PaymentRequest paymentRequest) {
        return new StripePaymentRequest(paymentRequest.amount(), paymentRequest.currency());
    }

    private PaymentResponse constructPaymentResponse(StripePaymentResponse stripePaymentResponse) {
        return new PaymentResponse(stripePaymentResponse.isSuccess(), stripePaymentResponse.transactionId());
    }
}
