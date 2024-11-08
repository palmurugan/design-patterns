package com.pal.design.pattern.prototype.service;

import com.pal.design.pattern.prototype.dto.VariantRequest;
import com.pal.design.pattern.prototype.entity.Product;

public interface ProductService {

    Product saveBaseProduct(Product product);

    Product saveVariant(Long baseProductId, VariantRequest variant);
}
