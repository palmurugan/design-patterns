package com.pal.design.pattern.prototype.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product implements ProductPrototype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "storage")
    private int storage;

    @Column(name = "warranty")
    private int warranty;

    @Column(name = "price")
    private double price;

    @Override
    public ProductPrototype cloneProduct() {
        try {
            Product product = (Product) super.clone();
            product.setId(null);
            return product;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
