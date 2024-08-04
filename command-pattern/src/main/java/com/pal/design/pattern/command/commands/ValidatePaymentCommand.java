package com.pal.design.pattern.command.commands;

import com.pal.design.pattern.command.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ValidatePaymentCommand implements OrderCommand {

    private static final Logger log = LoggerFactory.getLogger(ValidatePaymentCommand.class);
    private final PaymentService paymentService;

    public ValidatePaymentCommand(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Execute the validate payment command
     */
    @Override
    public void execute() {
        log.info("[Command]: Executing validate payment command");
        paymentService.validatePayment();
    }
}
