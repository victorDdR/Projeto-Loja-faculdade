package com.trabalho.faculdade.impacta.domain.repository;

import com.trabalho.faculdade.impacta.domain.model.Category;

import java.util.List;

public interface Categories {

    List<Category> findAll();
    Category findById(Long categoryId);
    void save(Category category);
}
