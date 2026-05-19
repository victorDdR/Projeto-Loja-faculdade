package com.trabalho.faculdade.impacta.product.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Products {

    Page<Product> findAll(Pageable pageable);
    Product save(Product product);
    Product findById(Long productId);
    Page<Product> findAllAvailable(Pageable pageable);
}
