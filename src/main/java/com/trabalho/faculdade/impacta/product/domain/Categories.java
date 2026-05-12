package com.trabalho.faculdade.impacta.product.domain;

import java.util.List;

public interface Categories {

    List<Category> findAll();
    Category findById(Long categoryId);
    Category save(Category category);
}
