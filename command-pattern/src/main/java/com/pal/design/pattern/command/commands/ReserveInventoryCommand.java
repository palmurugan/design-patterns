package com.pal.design.pattern.command.commands;

import com.pal.design.pattern.command.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ReserveInventoryCommand implements OrderCommand {

    private static final Logger log = LoggerFactory.getLogger(ReserveInventoryCommand.class);
    private final InventoryService inventoryService;

    public ReserveInventoryCommand(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    /**
     * Execute the reserve inventory command
     */
    @Override
    public void execute() {
        log.info("[Command]: Executing reserve inventory command");
        inventoryService.reserveInventory();
    }
}
