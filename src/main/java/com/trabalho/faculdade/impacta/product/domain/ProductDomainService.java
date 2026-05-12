package com.trabalho.faculdade.impacta.product.domain;

import com.trabalho.faculdade.impacta.product.presentation.CategoryDTO;
import com.trabalho.faculdade.impacta.product.presentation.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDomainService {

    private final Products products;

    @Autowired
    ProductDomainService(Products products) {
        this.products = products;
    }

    public List<ProductDTO> findAll() {
        List<Product> productList = products.findAll();
        return productListToDTOList(productList);
    }

    public void save(Product product) {
        products.save(product);
    }

    public void deleteById(Long productId) {
        Product product = products.findById(productId);
        product.delete();
        products.save(product);
    }

    public List<ProductDTO> findAllAvailable() {
        List<Product> availableProductsList = products.findAvailable();
        return productListToDTOList(availableProductsList);
    }

    public Product findById(Long id) {
        return products.findById(id);
    }

    private List<ProductDTO> productListToDTOList(List<Product> productList) {
        List<ProductDTO> productDTOS = new ArrayList<>();

        productList.forEach(product ->
                productDTOS.add(new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getQuantity(),
                        new CategoryDTO(product.getCategory().getId(), product.getCategory().getName())))
        );

        return productDTOS;
    }

}
