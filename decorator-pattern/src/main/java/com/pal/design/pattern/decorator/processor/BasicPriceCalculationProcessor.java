package com.pal.design.pattern.decorator.processor;

public class BasicPriceCalculationProcessor implements PriceCalculationProcessor {

    @Override
    public double calculatePrice(double price) {
        return price;
    }
}
