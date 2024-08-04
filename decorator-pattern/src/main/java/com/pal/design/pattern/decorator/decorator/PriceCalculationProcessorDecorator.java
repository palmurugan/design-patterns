package com.pal.design.pattern.decorator.decorator;

import com.pal.design.pattern.decorator.processor.PriceCalculationProcessor;

public abstract class PriceCalculationProcessorDecorator implements PriceCalculationProcessor {

    protected PriceCalculationProcessor decoratedPriceCalculationProcessor;

    public PriceCalculationProcessorDecorator(PriceCalculationProcessor decoratedPriceCalculationProcessor) {
        this.decoratedPriceCalculationProcessor = decoratedPriceCalculationProcessor;
    }

    @Override
    public double calculatePrice(double price) {
        return decoratedPriceCalculationProcessor.calculatePrice(price);
    }
}
