package com.trabalho.faculdade.impacta.sale.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleItemServiceDomain {

    private final SaleItems saleItems;

    @Autowired
    SaleItemServiceDomain(SaleItems saleItems) {
        this.saleItems = saleItems;
    }

    public void save(SaleItem saleItem) {
        saleItems.save(saleItem);
    }
}
