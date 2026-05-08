package com.trabalho.faculdade.impacta.domain.service;

import com.trabalho.faculdade.impacta.domain.model.SaleItem;
import com.trabalho.faculdade.impacta.domain.repository.SaleItems;
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
