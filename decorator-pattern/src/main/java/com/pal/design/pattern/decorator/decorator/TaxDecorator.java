package com.pal.design.pattern.decorator.decorator;

import com.pal.design.pattern.decorator.processor.PriceCalculationProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

public class TaxDecorator extends PriceCalculationProcessorDecorator {
    private static final Logger log = LoggerFactory.getLogger(TaxDecorator.class);
    // 5% tax
    private double taxRate = 0.05;

    public TaxDecorator(@Qualifier("basicPriceCalculationProcessor") PriceCalculationProcessor decoratedPriceCalculationProcessor) {
        super(decoratedPriceCalculationProcessor);
    }

    @Override
    public double calculatePrice(double price) {
        double taxedPrice = price + (price * taxRate);
        log.info("[Decorator] Tax applied on price: {}", taxedPrice);
        return super.calculatePrice(taxedPrice);
    }
}
