package com.pal.design.pattern.command.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private static final Logger log = LoggerFactory.getLogger(InventoryService.class);

    /**
     * Reserve inventory
     * <p>
     * throw custom exception if inventory is not available
     */
    public void reserveInventory() {
        log.info("[Service]: Reserving inventory");
    }
}
