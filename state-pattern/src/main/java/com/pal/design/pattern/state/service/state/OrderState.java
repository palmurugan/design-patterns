package com.pal.design.pattern.state.service.state;

import com.pal.design.pattern.state.domain.Order;
import com.pal.design.pattern.state.domain.enumeration.OrderStatus;

public interface OrderState {

    void nextState(Order order);

    void previousState(Order order);

    OrderStatus getCurrentState(Order order);

}
