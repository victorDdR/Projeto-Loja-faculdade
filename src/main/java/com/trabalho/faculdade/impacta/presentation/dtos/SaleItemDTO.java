package com.trabalho.faculdade.impacta.presentation.dtos;

import java.math.BigDecimal;

public record SaleItemDTO(ProductDTO productDTO, int quantity) {

    public BigDecimal getTotalPrice() {
        return productDTO.price().multiply(BigDecimal.valueOf(quantity));
    }

}
