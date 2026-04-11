package com.trabalho.faculdade.impacta.domain.repository;

import com.trabalho.faculdade.impacta.domain.model.Product;

import java.util.List;

public interface Products {

    List<Product> findAll();
    void save(Product product);
    Product findById(Long productId);
}
