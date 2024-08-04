package com.pal.design.pattern.command.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    /**
     * Validate order
     * <p>
     * throw custom exception if order is not valid
     */
    public void validateOrder() {
        log.info("[Service]: Validating order");
    }
}
