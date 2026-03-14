package com.trabalho.faculdade.impacta.domain.repository.products;

import com.trabalho.faculdade.impacta.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class ProductsImpl implements Products{

    private final ProductRepository productRepository;

    @Autowired
    ProductsImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
