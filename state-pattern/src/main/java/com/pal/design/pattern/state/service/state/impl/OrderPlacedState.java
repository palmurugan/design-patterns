package com.pal.design.pattern.state.service.state.impl;

import com.pal.design.pattern.state.domain.Order;
import com.pal.design.pattern.state.domain.enumeration.OrderStatus;
import com.pal.design.pattern.state.service.state.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderPlacedState implements OrderState {

    @Override
    public void nextState(Order order) {
        log.info("[State]: Order is in placed state, changing it to Payment Processed state");
        // Add custom logic to validate payment
        order.setOrderStatus(OrderStatus.PAYMENT_PROCESSED);
    }

    @Override
    public void previousState(Order order) {
        log.info("[State]: Order is in placed state, can't change it to previous state");
    }

    @Override
    public OrderStatus getCurrentState(Order order) {
        log.info("[State]: Order is in placed state");
        return order.getOrderStatus();
    }
}
