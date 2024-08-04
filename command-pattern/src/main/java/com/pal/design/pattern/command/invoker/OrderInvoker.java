package com.pal.design.pattern.command.invoker;

import com.pal.design.pattern.command.commands.OrderCommand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderInvoker {
    private final List<OrderCommand> orderCommands = new ArrayList<>();

    /**
     * This method will add the command to the orderCommands list.
     *
     * @param orderCommand OrderCommand
     */
    public void addCommand(OrderCommand orderCommand) {
        orderCommands.add(orderCommand);
    }

    /**
     * This method will execute all the commands in the orderCommands list.
     */
    public void placeOrder() {
        orderCommands.forEach(OrderCommand::execute);
    }
}
