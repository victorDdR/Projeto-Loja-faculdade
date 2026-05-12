package com.trabalho.faculdade.impacta.sale.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleItemService {

    private final SaleItems saleItems;

    @Autowired
    SaleItemService(SaleItems saleItems) {
        this.saleItems = saleItems;
    }

    public void save(SaleItem saleItem) {
        saleItems.save(saleItem);
    }
}
