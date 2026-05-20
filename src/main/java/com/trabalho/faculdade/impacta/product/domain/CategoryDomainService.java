package com.trabalho.faculdade.impacta.product.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryDomainService {

    private final Categories categories;

    @Autowired
    CategoryDomainService(Categories categories) {
        this.categories = categories;
    }

    public Page<Category> findAll(Pageable pageable) {
        return categories.findAll(pageable);
    }

    public Category findById(Long categoryId) {
        return categories.findById(categoryId);
    }

    public Category save(Category category) {
        return categories.save(category);
    }

}
