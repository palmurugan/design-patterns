package com.pal.design.pattern.state.service;

import com.pal.design.pattern.state.domain.Order;

import java.util.Optional;

public interface OrderService {

    Optional<Order> placeOrder(Order order);

    Optional<Order> processNextStep(Long orderId);
}
