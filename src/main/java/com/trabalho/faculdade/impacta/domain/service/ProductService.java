package com.trabalho.faculdade.impacta.domain.service;

import com.trabalho.faculdade.impacta.domain.model.Product;
import com.trabalho.faculdade.impacta.domain.repository.products.Products;
import com.trabalho.faculdade.impacta.presentation.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final Products products;

    @Autowired
    ProductService(Products products) {
        this.products = products;
    }

    public List<ProductDTO> findAll() {
        List<ProductDTO> productDTOS = new ArrayList<>();

        List<Product> productList = products.findAll();
        productList.forEach(product -> {
            productDTOS.add(new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getStock()));
        });

        return productDTOS;
    }

}
