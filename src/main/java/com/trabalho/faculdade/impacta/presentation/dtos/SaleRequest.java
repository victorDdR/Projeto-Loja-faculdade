package com.trabalho.faculdade.impacta.presentation.dtos;

import java.math.BigDecimal;
import java.util.List;

public record SaleRequest(List<SaleItemDTO> items, BigDecimal total) {
}
