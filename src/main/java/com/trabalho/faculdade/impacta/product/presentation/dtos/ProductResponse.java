package com.trabalho.faculdade.impacta.product.presentation.dtos;

import java.math.BigDecimal;

public record ProductResponse(Long id, String productName, BigDecimal price, int stock, CategoryDTO category) {
}
