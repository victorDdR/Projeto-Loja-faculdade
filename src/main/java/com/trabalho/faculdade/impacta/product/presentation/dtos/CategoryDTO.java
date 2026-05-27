package com.trabalho.faculdade.impacta.product.presentation.dtos;

import com.trabalho.faculdade.impacta.product.domain.Category;
import jakarta.validation.constraints.NotBlank;

public record CategoryDTO(Long id, @NotBlank String name) {

    public CategoryDTO(Category category) {
        this(category.getId(), category.getName());
    }

}
