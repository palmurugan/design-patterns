package com.pal.design.pattern.state.service.state;

import com.pal.design.pattern.state.domain.Order;
import com.pal.design.pattern.state.service.state.impl.DeliveredState;
import com.pal.design.pattern.state.service.state.impl.OrderPlacedState;
import com.pal.design.pattern.state.service.state.impl.PaymentProcessedState;
import com.pal.design.pattern.state.service.state.impl.ShippedState;
import org.springframework.stereotype.Component;

@Component
public class OrderContext {

    private final OrderPlacedState orderPlacedState;
    private final PaymentProcessedState paymentProcessedState;
    private final ShippedState shippedState;
    private final DeliveredState deliveredState;

    private OrderState orderState;

    public OrderContext(OrderPlacedState orderPlacedState, PaymentProcessedState paymentProcessedState, ShippedState shippedState, DeliveredState deliveredState) {
        this.orderPlacedState = orderPlacedState;
        this.paymentProcessedState = paymentProcessedState;
        this.shippedState = shippedState;
        this.deliveredState = deliveredState;
    }

    public OrderState getOrderState(Order order) {
        return switch (order.getOrderStatus()) {
            case ORDER_PLACED -> orderPlacedState;
            case PAYMENT_PROCESSED -> paymentProcessedState;
            case ORDER_SHIPPED -> shippedState;
            case ORDER_DELIVERED -> deliveredState;
        };
    }
}
