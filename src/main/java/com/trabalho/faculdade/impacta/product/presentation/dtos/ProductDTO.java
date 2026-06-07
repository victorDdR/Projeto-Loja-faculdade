package com.trabalho.faculdade.impacta.product.presentation.dtos;

import com.trabalho.faculdade.impacta.product.domain.Product;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductDTO(Long id,
                         @NotBlank @Size(min = 5, max = 25)
                         String productName,
                         @NotNull
                         @Digits(integer = 1, fraction = 2) @DecimalMin(value = "5.00") @DecimalMax(value = "99999.99")
                         BigDecimal price,
                         @NotNull @Positive @Max(value = 9999)
                         Integer stock,
                         @NotNull
                         CategoryDTO category) {

    public ProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice(), product.getQuantity(),
                new CategoryDTO(product.getCategory()));
    }

}
