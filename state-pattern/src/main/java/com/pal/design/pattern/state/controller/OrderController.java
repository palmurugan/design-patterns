package com.pal.design.pattern.state.controller;

import com.pal.design.pattern.state.domain.Order;
import com.pal.design.pattern.state.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        log.info("[Controller]: Rest request to place order: {}", order);
        return ResponseEntity.ok(orderService.placeOrder(order).orElseThrow());
    }

    @PutMapping("/{orderId}/process-payment")
    public ResponseEntity<Order> processPayment(@PathVariable Long orderId) {
        log.info("[Controller]: Rest request to process payment for order: {}", orderId);
        return ResponseEntity.ok(orderService.processNextStep(orderId).orElseThrow());
    }

    @PutMapping("/{orderId}/ship-order")
    public ResponseEntity<Order> shipOrder(@PathVariable Long orderId) {
        log.info("[Controller]: Rest request to ship order: {}", orderId);
        return ResponseEntity.ok(orderService.processNextStep(orderId).orElseThrow());
    }

    @PutMapping("/{orderId}/deliver-order")
    public ResponseEntity<Order> deliverOrder(@PathVariable Long orderId) {
        log.info("[Controller]: Rest request to deliver order: {}", orderId);
        return ResponseEntity.ok(orderService.processNextStep(orderId).orElseThrow());
    }
}
