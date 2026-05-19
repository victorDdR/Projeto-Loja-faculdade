package com.trabalho.faculdade.impacta.product.domain;

import com.trabalho.faculdade.impacta.product.presentation.dtos.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryDomainService {

    private final Categories categories;

    @Autowired
    CategoryDomainService(Categories categories) {
        this.categories = categories;
    }

    public List<CategoryDTO> findAll() {
        List<Category> categories = this.categories.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        categories.forEach(category ->
                categoryDTOS.add(new CategoryDTO(category.getId(), category.getName()))
        );

        return categoryDTOS;
    }

    public Category findById(Long categoryId) {
        return categories.findById(categoryId);
    }

    public Category save(Category category) {
        return categories.save(category);
    }

}
