package com.trabalho.faculdade.impacta.product.infra;

import com.trabalho.faculdade.impacta.product.domain.Category;
import com.trabalho.faculdade.impacta.product.domain.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriesImpl implements Categories {

    private final CategoryRepository categoryRepository;

    @Autowired
    CategoriesImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> findAll() {
        return categoryRepository.findByDeletedFalse();
    }

    @Override
    public Category findById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

}
