package com.trabalho.faculdade.impacta.infra.repository;

import com.trabalho.faculdade.impacta.domain.model.Category;
import com.trabalho.faculdade.impacta.domain.repository.Categories;
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
}
