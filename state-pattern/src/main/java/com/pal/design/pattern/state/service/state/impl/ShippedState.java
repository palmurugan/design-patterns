package com.pal.design.pattern.state.service.state.impl;

import com.pal.design.pattern.state.domain.Order;
import com.pal.design.pattern.state.domain.enumeration.OrderStatus;
import com.pal.design.pattern.state.service.state.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ShippedState implements OrderState {

    @Override
    public void nextState(Order order) {
        log.info("[State]: Order is in Shipped state, changing it to Delivered state");
        // Add custom logic to validate payment
        order.setOrderStatus(OrderStatus.ORDER_DELIVERED);
    }

    @Override
    public void previousState(Order order) {
        log.info("[State]: Order is in Shipped state, changing it to Payment Processed state");
        order.setOrderStatus(OrderStatus.PAYMENT_PROCESSED);
    }

    @Override
    public OrderStatus getCurrentState(Order order) {
        log.info("[State]: Order is in Shipped state");
        return order.getOrderStatus();
    }
}
