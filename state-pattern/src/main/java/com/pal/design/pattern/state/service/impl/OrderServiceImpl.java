package com.pal.design.pattern.state.service.impl;

import com.pal.design.pattern.state.domain.Order;
import com.pal.design.pattern.state.domain.enumeration.OrderStatus;
import com.pal.design.pattern.state.repository.OrderRepository;
import com.pal.design.pattern.state.service.OrderService;
import com.pal.design.pattern.state.service.state.OrderContext;
import com.pal.design.pattern.state.service.state.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderContext orderContext;

    public OrderServiceImpl(OrderRepository orderRepository, OrderContext orderContext) {
        this.orderRepository = orderRepository;
        this.orderContext = orderContext;
    }

    /**
     * Place order with default state as OrderPlacedState
     *
     * @param order Order object
     * @return Optional<Order>
     */
    @Override
    public Optional<Order> placeOrder(Order order) {
        log.info("[Service]: Placing order with default state: {}", OrderStatus.ORDER_PLACED);
        order.setOrderStatus(OrderStatus.ORDER_PLACED);  // Default state is OrderPlacedState
        return Optional.of(orderRepository.save(order));
    }

    /**
     * Handle order status based on the current state
     *
     * @param orderId Order Id
     * @return Optional<Order>
     */
    @Override
    public Optional<Order> processNextStep(Long orderId) {
        log.info("[Service]: Handling order status for order: {}", orderId);
        orderRepository.findById(orderId).ifPresent(order -> {
            OrderState orderState = orderContext.getOrderState(order);
            orderState.nextState(order);
            orderRepository.save(order);
        });
        return orderRepository.findById(orderId); // Returning the updated order
    }
}
