package com.trabalho.faculdade.impacta.presentation.dtos;

import java.math.BigDecimal;

public record ProductDTO(Long id, String product_name, BigDecimal price, int stock) {
}
