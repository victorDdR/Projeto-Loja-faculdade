package com.trabalho.faculdade.impacta.product.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductDomainService {

    private final Products products;

    @Autowired
    ProductDomainService(Products products) {
        this.products = products;
    }

    public Page<Product> findAll(Pageable pageable) {
        return products.findAll(pageable);
    }

    public Product save(Product product) {
        log.info("[PRODUCT] Creating product {}", product);
        return products.save(product);
    }

    public void deleteById(Long productId) {
        Product product = products.findById(productId);
        log.info("[PRODUCT] Deleting product {}", product);
        product.delete();
        products.save(product);
    }

    public Page<Product> findAllAvailable(Pageable pageable) {
        return products.findAllAvailable(pageable);
    }

    public Product findById(Long id) {
        return products.findById(id);
    }

}
