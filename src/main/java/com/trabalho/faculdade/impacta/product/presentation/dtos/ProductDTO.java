package com.trabalho.faculdade.impacta.product.presentation.dtos;

import com.trabalho.faculdade.impacta.product.domain.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductDTO(Long id,
                         @NotBlank
                         String productName,
                         @NotNull
                         BigDecimal price,
                         @NotNull
                         Integer stock,
                         @NotNull
                         CategoryDTO category) {

    public ProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice(), product.getQuantity(),
                new CategoryDTO(product.getCategory()));
    }

}
