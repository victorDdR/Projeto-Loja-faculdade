package com.trabalho.faculdade.impacta.product.app;

import com.trabalho.faculdade.impacta.product.domain.Category;
import com.trabalho.faculdade.impacta.product.domain.Product;
import com.trabalho.faculdade.impacta.product.domain.CategoryDomainService;
import com.trabalho.faculdade.impacta.product.domain.ProductDomainService;
import com.trabalho.faculdade.impacta.product.presentation.CategoryDTO;
import com.trabalho.faculdade.impacta.product.presentation.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase {

    private final ProductDomainService productDomainService;
    private final CategoryDomainService categoryDomainService;

    @Autowired
    CreateProductUseCase(ProductDomainService productDomainService, CategoryDomainService categoryDomainService) {
        this.productDomainService = productDomainService;
        this.categoryDomainService = categoryDomainService;
    }

    public void createProduct(ProductDTO productDTO) {
        Category category = getCategory(productDTO.category());
        productDomainService.save(new Product(productDTO.productName(), productDTO.price(), productDTO.stock(), category));
    }

    private Category getCategory(CategoryDTO categoryDTO) {
        if (categoryDTO.id() == null) {
            return categoryDomainService.save(new Category(categoryDTO.name()));
        }

        return categoryDomainService.findById(categoryDTO.id());
    }

}
