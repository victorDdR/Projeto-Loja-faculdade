package com.trabalho.faculdade.impacta.sale.presentation;

import com.trabalho.faculdade.impacta.product.presentation.ProductDTO;

import java.math.BigDecimal;

public record SaleItemDTO(ProductDTO productDTO, int quantity) {

    public BigDecimal getTotalPrice() {
        return productDTO.price().multiply(BigDecimal.valueOf(quantity));
    }

}
