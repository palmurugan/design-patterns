package com.pal.design.pattern.prototype.repository;

import com.pal.design.pattern.prototype.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductId(Long baseProductId);
}
