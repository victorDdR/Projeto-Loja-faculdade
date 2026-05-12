package com.trabalho.faculdade.impacta.product.presentation;

import java.math.BigDecimal;

public record ProductDTO(Long id, String productName, BigDecimal price, int stock, CategoryDTO category) {
}
