package com.trabalho.faculdade.impacta.product.domain;

import java.util.List;

public interface Products {

    List<Product> findAll();
    void save(Product product);
    Product findById(Long productId);
    List<Product> findAvailable();
}
