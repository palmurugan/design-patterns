package com.pal.design.pattern.state.service.state.impl;

import com.pal.design.pattern.state.domain.Order;
import com.pal.design.pattern.state.domain.enumeration.OrderStatus;
import com.pal.design.pattern.state.service.state.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentProcessedState implements OrderState {

    @Override
    public void nextState(Order order) {
        log.info("[State]: Order is in Payment Processed state, changing it to Shipped state");
        // Add custom logic to validate payment
        if (validatePayment()) {
            order.setOrderStatus(OrderStatus.ORDER_SHIPPED);
        } else {
            log.info("[State]: Payment is not processed yet, can't change the state to Shipped");
        }
    }

    @Override
    public void previousState(Order order) {
        log.info("[State]: Order is in Payment Processed state, changing it to Order Placed state");
        order.setOrderStatus(OrderStatus.ORDER_PLACED);
    }

    @Override
    public OrderStatus getCurrentState(Order order) {
        log.info("[State]: Order is in Payment Processed state");
        return order.getOrderStatus();
    }

    /**
     * Custom logic to validate payment
     *
     * @return boolean
     */
    private boolean validatePayment() {
        return true;
    }
}
