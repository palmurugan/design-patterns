package com.pal.design.pattern.decorator.service;

import com.pal.design.pattern.decorator.decorator.DiscountDecorator;
import com.pal.design.pattern.decorator.decorator.TaxDecorator;
import com.pal.design.pattern.decorator.processor.PriceCalculationProcessor;
import com.pal.design.pattern.decorator.response.ProductPrice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriceCalculationServiceImpl implements PriceCalculationService {

    private static final Logger log = LoggerFactory.getLogger(PriceCalculationServiceImpl.class);
    private final PriceCalculationProcessor basicPriceCalculationProcessor;

    public PriceCalculationServiceImpl(
            @Qualifier("basicPriceCalculationProcessor") PriceCalculationProcessor priceCalculationProcessor) {
        this.basicPriceCalculationProcessor = priceCalculationProcessor;
    }

    @Override
    public Optional<ProductPrice> calculatePrice(String productId) {
        PriceCalculationProcessor processor = basicPriceCalculationProcessor;
        processor = new DiscountDecorator(processor);
        processor = new TaxDecorator(processor);
        double price = processor.calculatePrice(100);
        log.info("Price for product {} is {}", productId, price);
        return Optional.of(new ProductPrice("P1001", "Samsung TV", price));
    }
}
