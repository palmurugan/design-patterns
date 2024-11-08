package com.pal.design.pattern.prototype.controller;

import com.pal.design.pattern.prototype.dto.VariantRequest;
import com.pal.design.pattern.prototype.entity.Product;
import com.pal.design.pattern.prototype.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@Log4j2
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> saveBaseProduct(@RequestBody Product product) {
        log.debug("Rest request to save the base product {}", product);
        return ResponseEntity.ok(productService.saveBaseProduct(product));
    }

    @PostMapping("/{baseProductId}/variants")
    public ResponseEntity<Product> saveVariants(@PathVariable Long baseProductId, @RequestBody VariantRequest variantRequest) {
        log.debug("Rest request to create the variant for the base product");
        return ResponseEntity.ok(productService.saveVariant(baseProductId, variantRequest));
    }
}
