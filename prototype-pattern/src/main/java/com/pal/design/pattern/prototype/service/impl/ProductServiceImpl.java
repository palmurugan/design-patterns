package com.pal.design.pattern.prototype.service.impl;

import com.pal.design.pattern.prototype.dto.VariantRequest;
import com.pal.design.pattern.prototype.entity.Product;
import com.pal.design.pattern.prototype.repository.ProductRepository;
import com.pal.design.pattern.prototype.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveBaseProduct(Product product) {
        log.debug("Save base product with the detail {}", product);
        return productRepository.save(product);
    }

    @Override
    public Product saveVariant(Long baseProductId, VariantRequest variant) {
        log.debug("Save variant for the base product {}", baseProductId);
        Product baseProduct = productRepository.findByProductId(baseProductId)
                .orElseThrow(() -> new NoSuchElementException("Base product not found!"));

        // Cloning the baseProduct and adding the variant details
        Product variantDetail = (Product) baseProduct.cloneProduct();
        variantDetail.setColor(variant.color());
        variantDetail.setModel(variant.model());
        variantDetail.setWarranty(variant.warranty());
        variantDetail.setPrice(variant.price());
        variantDetail.setStorage(variant.storage());

        // Save the variant details
        return productRepository.save(variantDetail);
    }
}
