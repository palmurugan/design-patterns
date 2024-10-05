package com.pal.design.pattern.state.service.state.impl;

import com.pal.design.pattern.state.domain.Order;
import com.pal.design.pattern.state.domain.enumeration.OrderStatus;
import com.pal.design.pattern.state.service.state.OrderState;
import org.springframework.stereotype.Component;

@Component
public class DeliveredState implements OrderState {

    @Override
    public void nextState(Order order) {

    }

    @Override
    public void previousState(Order order) {

    }

    @Override
    public OrderStatus getCurrentState(Order order) {
        return null;
    }
}
