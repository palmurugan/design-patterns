package com.pal.design.pattern.command.controller;

import com.pal.design.pattern.command.processor.OrderProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    private final OrderProcessor orderProcessor;

    public OrderController(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    /**
     * Place an order
     *
     * @return ResponseEntity<Void>
     */
    @PostMapping
    public ResponseEntity<Void> placeOrder() {
        log.info("Rest request to place an order");
        orderProcessor.processOrder();
        return ResponseEntity.ok().build();
    }
}
