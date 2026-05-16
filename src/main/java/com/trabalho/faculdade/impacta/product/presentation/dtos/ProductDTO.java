package com.trabalho.faculdade.impacta.product.presentation.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductDTO(Long id,
                         @NotBlank
                         String productName,
                         @NotNull
                         BigDecimal price,
                         int stock,
                         @NotNull
                         CategoryDTO category) {
}
