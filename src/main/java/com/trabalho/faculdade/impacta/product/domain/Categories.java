package com.trabalho.faculdade.impacta.product.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Categories {

    Page<Category> findAll(Pageable pageable);
    Category findById(Long categoryId);
    Category save(Category category);
}
