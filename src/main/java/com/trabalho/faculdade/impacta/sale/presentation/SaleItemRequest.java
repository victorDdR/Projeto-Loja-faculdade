package com.trabalho.faculdade.impacta.sale.presentation;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record SaleItemRequest(
        @NotNull
        Long productId,
        @NotNull
        BigDecimal productPrice,
        @NotNull
        Integer quantity
) {
    public BigDecimal getTotalPrice() {
        return productPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
