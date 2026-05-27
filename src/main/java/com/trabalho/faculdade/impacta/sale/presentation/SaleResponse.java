package com.trabalho.faculdade.impacta.sale.presentation;

import com.trabalho.faculdade.impacta.sale.domain.Sale;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record SaleResponse(Long id, BigDecimal total, LocalDateTime saleDate, List<SaleItemResponse> items) {

    public SaleResponse(Sale sale) {
        List<SaleItemResponse> items = sale.getItems().stream().map(SaleItemResponse::new).toList();
        this(sale.getId(), sale.getTotal(), sale.getSaleDate(), items);
    }
}
