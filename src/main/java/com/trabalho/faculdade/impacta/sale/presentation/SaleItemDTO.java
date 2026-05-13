package com.trabalho.faculdade.impacta.sale.presentation;

import com.trabalho.faculdade.impacta.product.presentation.dtos.ProductResponse;

import java.math.BigDecimal;

public record SaleItemDTO(ProductResponse productResponse, int quantity) {

    public BigDecimal getTotalPrice() {
        return productResponse.price().multiply(BigDecimal.valueOf(quantity));
    }

}
