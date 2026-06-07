package com.trabalho.faculdade.impacta.product.presentation.dtos;

import com.trabalho.faculdade.impacta.product.domain.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryDTO(Long id, @NotBlank @Size(min = 3, max = 20) String name) {

    public CategoryDTO(Category category) {
        this(category.getId(), category.getName());
    }

}
