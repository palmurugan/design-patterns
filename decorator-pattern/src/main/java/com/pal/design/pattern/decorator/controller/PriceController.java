package com.pal.design.pattern.decorator.controller;

import com.pal.design.pattern.decorator.response.ProductPrice;
import com.pal.design.pattern.decorator.service.PriceCalculationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class PriceController {

    private final PriceCalculationService priceCalculationService;

    public PriceController(PriceCalculationService priceCalculationService) {
        this.priceCalculationService = priceCalculationService;
    }

    @GetMapping("/{id}/price")
    public ResponseEntity<ProductPrice> calculatePrice(@PathVariable String id) {
        return new ResponseEntity<>(
                priceCalculationService.calculatePrice(id).orElseThrow(RuntimeException::new), HttpStatus.OK);
    }
}
