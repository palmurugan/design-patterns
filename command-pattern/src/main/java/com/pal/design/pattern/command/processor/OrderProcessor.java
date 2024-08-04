package com.pal.design.pattern.command.processor;

import com.pal.design.pattern.command.commands.ReserveInventoryCommand;
import com.pal.design.pattern.command.commands.ValidateOrderCommand;
import com.pal.design.pattern.command.commands.ValidatePaymentCommand;
import com.pal.design.pattern.command.invoker.OrderInvoker;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {

    private final OrderInvoker orderInvoker;

    /**
     * Constructor to initialize the OrderProcessor.
     *
     * @param orderInvoker            OrderInvoker
     * @param validateOrderCommand    ValidateOrderCommand
     * @param validatePaymentCommand  ValidatePaymentCommand
     * @param reserveInventoryCommand ReserveInventoryCommand
     */
    public OrderProcessor(OrderInvoker orderInvoker, ValidateOrderCommand validateOrderCommand,
                          ValidatePaymentCommand validatePaymentCommand,
                          ReserveInventoryCommand reserveInventoryCommand) {
        this.orderInvoker = orderInvoker;
        orderInvoker.addCommand(validateOrderCommand);
        orderInvoker.addCommand(validatePaymentCommand);
        orderInvoker.addCommand(reserveInventoryCommand);
    }

    /**
     * This method will process the order.
     */
    public void processOrder() {
        orderInvoker.placeOrder();
    }
}
