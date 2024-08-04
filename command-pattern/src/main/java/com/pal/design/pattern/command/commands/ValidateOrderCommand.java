package com.pal.design.pattern.command.commands;

import com.pal.design.pattern.command.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ValidateOrderCommand implements OrderCommand {

    private static final Logger log = LoggerFactory.getLogger(ValidateOrderCommand.class);
    private final OrderService orderService;

    public ValidateOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Execute the validate order command
     */
    @Override
    public void execute() {
        log.info("[Command]: Executing validate order command");
        orderService.validateOrder();
    }
}
