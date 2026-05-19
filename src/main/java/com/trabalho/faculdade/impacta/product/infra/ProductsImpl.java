package com.trabalho.faculdade.impacta.product.infra;

import com.trabalho.faculdade.impacta.product.domain.Product;
import com.trabalho.faculdade.impacta.product.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findByDeletedFalse(pageable);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Page<Product> findAllAvailable(Pageable pageable) {
        return productRepository.findAvailableProducts(pageable);
    }

}
