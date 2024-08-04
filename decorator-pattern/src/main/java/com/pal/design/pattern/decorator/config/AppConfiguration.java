package com.pal.design.pattern.decorator.config;

import com.pal.design.pattern.decorator.decorator.DiscountDecorator;
import com.pal.design.pattern.decorator.decorator.TaxDecorator;
import com.pal.design.pattern.decorator.processor.BasicPriceCalculationProcessor;
import com.pal.design.pattern.decorator.processor.PriceCalculationProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean("basicPriceCalculationProcessor")
    public PriceCalculationProcessor basicPriceCalculationProcessor() {
        return new BasicPriceCalculationProcessor();
    }

    @Bean("discountDecorator")
    public PriceCalculationProcessor discountDecorator() {
        return new DiscountDecorator(basicPriceCalculationProcessor());
    }

    @Bean("taxDecorator")
    public PriceCalculationProcessor taxDecorator() {
        return new TaxDecorator(basicPriceCalculationProcessor());
    }
}
