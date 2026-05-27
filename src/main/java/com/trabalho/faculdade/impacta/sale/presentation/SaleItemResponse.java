package com.trabalho.faculdade.impacta.sale.presentation;

import com.trabalho.faculdade.impacta.sale.domain.SaleItem;

import java.math.BigDecimal;

public record SaleItemResponse(String productName, int quantity, BigDecimal totalPrice) {

    public SaleItemResponse(SaleItem saleItem) {
        this(saleItem.getProductName(), saleItem.getQuantity(), saleItem.getTotalPrice());
    }
}
