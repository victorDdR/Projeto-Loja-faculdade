package com.trabalho.faculdade.impacta.infra.repository;

import com.trabalho.faculdade.impacta.domain.model.Product;
import com.trabalho.faculdade.impacta.domain.repository.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class ProductsImpl implements Products {

    private final ProductRepository productRepository;

    @Autowired
    ProductsImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findByDeletedFalse();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public List<Product> findAvailable() {
        return productRepository.findAvailableProducts();
    }

}
