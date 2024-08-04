package com.pal.design.pattern.decorator.service;

import com.pal.design.pattern.decorator.response.ProductPrice;

import java.util.Optional;

public interface PriceCalculationService {

    Optional<ProductPrice> calculatePrice(String productId);
}
