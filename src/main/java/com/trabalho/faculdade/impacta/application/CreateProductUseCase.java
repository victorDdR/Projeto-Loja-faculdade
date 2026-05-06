package com.trabalho.faculdade.impacta.application;

import com.trabalho.faculdade.impacta.domain.model.Category;
import com.trabalho.faculdade.impacta.domain.model.Product;
import com.trabalho.faculdade.impacta.domain.service.CategoryService;
import com.trabalho.faculdade.impacta.domain.service.ProductService;
import com.trabalho.faculdade.impacta.presentation.dtos.CategoryDTO;
import com.trabalho.faculdade.impacta.presentation.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    CreateProductUseCase(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    public void createProduct(ProductDTO productDTO) {
        Category category = getCategory(productDTO.category());
        productService.save(new Product(productDTO.productName(), productDTO.price(), productDTO.stock(), category));
    }

    private Category getCategory(CategoryDTO categoryDTO) {
        if (categoryDTO.id() == null) {
            return categoryService.save(new Category(categoryDTO.name()));
        }

        return categoryService.findById(categoryDTO.id());
    }

}
