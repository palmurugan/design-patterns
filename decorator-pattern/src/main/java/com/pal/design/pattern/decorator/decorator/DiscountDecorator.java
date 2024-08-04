package com.pal.design.pattern.decorator.decorator;

import com.pal.design.pattern.decorator.processor.PriceCalculationProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

public class DiscountDecorator extends PriceCalculationProcessorDecorator {
    private static final Logger log = LoggerFactory.getLogger(DiscountDecorator.class);
    // 10% discount
    private final double discount = 0.1;

    public DiscountDecorator(@Qualifier("basicPriceCalculationProcessor") PriceCalculationProcessor decoratedPriceCalculationProcessor) {
        super(decoratedPriceCalculationProcessor);
    }

    @Override
    public double calculatePrice(double price) {
        double discountedPrice = price - (price * discount);
        log.info("[Decorator] Discount applied on price: {}", discountedPrice);
        return super.calculatePrice(discountedPrice);
    }
}
