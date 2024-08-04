package com.pal.design.pattern.command.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    /**
     * Validate payment
     * <p>
     * throw custom exception if payment is not valid
     */
    public void validatePayment() {
        log.info("[Service]: Validating payment");
    }
}
