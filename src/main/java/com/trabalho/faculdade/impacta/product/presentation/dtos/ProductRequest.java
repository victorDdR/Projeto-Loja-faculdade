package com.trabalho.faculdade.impacta.product.presentation.dtos;

import java.math.BigDecimal;

public record ProductRequest(String productName, BigDecimal price, int stock, CategoryDTO category) {
}
