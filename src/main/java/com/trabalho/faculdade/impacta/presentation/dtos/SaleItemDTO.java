package com.trabalho.faculdade.impacta.presentation.dtos;

import java.math.BigDecimal;

public record SaleItemDTO(ProductDTO productDTO, int quantity, BigDecimal unitPrice, BigDecimal totalPrice) {
}
